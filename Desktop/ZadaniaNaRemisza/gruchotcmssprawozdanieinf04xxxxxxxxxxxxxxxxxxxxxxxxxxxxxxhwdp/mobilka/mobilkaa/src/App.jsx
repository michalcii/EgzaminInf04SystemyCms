import { useMemo, useState } from 'react'
import './App.css'
import { CATEGORY_LABELS, initialPhotos } from './data/photos'

const CATEGORY_ORDER = [1, 2, 3]

const buildImageSrc = (filename) => new URL(`./assets/${filename}`, import.meta.url).href

function App() {
  const [photos, setPhotos] = useState(initialPhotos)
  const [activeCategories, setActiveCategories] = useState({ 1: true, 2: true, 3: true })

  const visiblePhotos = useMemo(
    () => photos.filter((photo) => activeCategories[photo.category]),
    [photos, activeCategories],
  )

  const toggleCategory = (category) => {
    setActiveCategories((current) => ({ ...current, [category]: !current[category] }))
  }

  const incrementDownloads = (id) => {
    setPhotos((current) =>
      current.map((photo) => (photo.id === id ? { ...photo, downloads: photo.downloads + 1 } : photo)),
    )
  }

  return (
    <main className="gallery container py-5">
      <div className="text-center text-md-start mb-4">
        <h1 className="display-5 fw-bold text-dark mb-2">Kategorie zdjęć</h1>
      </div>

      <div className="row g-3 mb-4">
        {CATEGORY_ORDER.map((category) => {
          const switchId = `category-${category}`
          return (
            <div className="col-12 col-md-4" key={category}>
              <div className="d-flex">
                <div className="form-check form-switch m-0">
                  <input
                    id={switchId}
                    className="form-check-input"
                    type="checkbox"
                    role="switch"
                    checked={activeCategories[category]}
                    onChange={() => toggleCategory(category)}
                  />
                </div>
                <label className="switch-label mb-0 fw-semibold" htmlFor={switchId}>
                  {CATEGORY_LABELS[category]}
                </label>
              </div>
            </div>
          )
        })}
      </div>

      {visiblePhotos.length > 0 ? (
        <section className="row g-4">
          {visiblePhotos.map((photo) => (
            <div className="col-12 col-md-6 col-lg-4" key={photo.id}>
              <article>
                <img
                  className="card-img-top photo-img"
                  src={buildImageSrc(photo.filename)}
                  alt={photo.alt}
                />
                  <h4 className="text-muted mb-3">Pobrań: {photo.downloads}</h4>
                  <button className="btn btn-success" onClick={() => incrementDownloads(photo.id)}>
                    Pobierz
                  </button>
              </article>
            </div>
          ))}
        </section>
      ) : (
        <div className="alert alert-info text-center" role="alert">
          Wybierz kategorię, aby zobaczyć zdjęcia.
        </div>
      )}
    </main>
  )
}

export default App
