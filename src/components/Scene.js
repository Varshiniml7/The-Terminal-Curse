import React, { useState, useEffect } from 'react';

function Scene() {
  const [scene, setScene] = useState(null);

  useEffect(() => {
    fetch('http://localhost:8080/api/scene/start')
      .then(res => res.json())
      .then(data => setScene(data));
  }, []);

  const handleChoice = (nextId) => {
    fetch(\`http://localhost:8080/api/scene/\${nextId}\`)
      .then(res => res.json())
      .then(data => setScene(data));
  };

  if (!scene) return <div>Loading...</div>;

  return (
    <div>
      <p>{scene.text}</p>
      <div className="mt-4">
        {scene.options.map((opt, index) => (
          <button key={index} onClick={() => handleChoice(opt.nextId)} className="block mt-2 bg-green-800 p-2 rounded">
            {opt.text}
          </button>
        ))}
      </div>
    </div>
  );
}

export default Scene;