
function showContent(sectionId) {
  const sections = document.querySelectorAll('.content-section');
  sections.forEach(section => {
    section.classList.remove('active');
  });

  const selectedSection = document.getElementById(sectionId);
  selectedSection.classList.add('active');
}

function toggleSidebar() {
  const sidebar = document.querySelector('.sidebar-icons');
  sidebar.classList.toggle('visible');
}
function adicionarItensAoMenu() {
  const sidebar = document.querySelector('.sidebar-icons');
  items.forEach(item => {
    const menuItem = document.createElement('div');
    menuItem.classList.add('menu-item');         
    menuItem.setAttribute('data-toggle', 'tooltip');
    menuItem.setAttribute('data-placement', 'right');
    menuItem.setAttribute('title',item);
    menuItem.innerHTML = `<i class="fas ${itemIcons[item]}"></i>`;     
    menuItem.onclick = function () {
      showContent(item);
      document.getElementById('index').style.display = "none";
    };
    sidebar.appendChild(menuItem);
  });
 
}
const itemIcons = {
    'doacao': 'fa-calendar',
    'historico': 'fa-history',
    'informacoes': 'fa-info-circle',
    'dashboard':'fa fa-dashboard',
    'perfil': 'fa-user'
    
};

const userData = JSON.parse(localStorage.getItem('userData'));
var items=[]
if (userData) {    
    const userName = userData.nome; 
    items = userData.itensMenu;    
    const userSpan = document.getElementById("user-name");
    userSpan.textContent = userName.substring(0, 9);
    adicionarItensAoMenu();
} else {
   
}

  
 


