import {createRouter, createWebHistory} from "vue-router"
import MainComponent from "../components/MainComponent.vue";
import AdminComponent from "../components/AdminComponent.vue";
import LoginComponent from "../components/LoginComponent.vue";
const routes = [
    {path: "/", component: MainComponent},
    {path: "/admin", component: AdminComponent},
    {path: "/loginAdmin", component: LoginComponent},
]

export default new createRouter({
    history: createWebHistory(),
    routes,
})