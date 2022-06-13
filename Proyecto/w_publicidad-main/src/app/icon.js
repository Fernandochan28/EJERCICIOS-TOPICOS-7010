const icons = document.querySelectorAll('.navegacion-principal');
icons.forEach (icon => {  
  icon.addEventListener('click', (event) => {
    icon.classList.toggle("open");
  });
});