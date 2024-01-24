
/* Set the width of the side navigation to 250px */
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
  }
  
  /* Set the width of the side navigation to 0 */
  function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
  }





// window.addEventListener('scroll', function() {
//     var content = document.querySelector('.pagecontent');
//     var intro = document.querySelector('.intro');
//     var introPosition = intro.getBoundingClientRect().top;
//     var screenPosition = window.innerHeight;
  
//     if (introPosition < screenPosition / 2) {
//       content.classList.add('visible');
//     } else {
//       content.classList.remove('visible');
//     }
//   });