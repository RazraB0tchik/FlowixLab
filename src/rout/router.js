import {createRouter, createWebHistory} from "vue-router"
import MainComponent from "../components/MainComponent";
import AdminComponent from "../components/AdminComponent";
const routes = [
    {path: "/", component: MainComponent},
    {path: "/admin", component: AdminComponent},
]

export default new createRouter({
    history: createWebHistory(),
    routes,
})