<template lang="html">
    <div class="container">
        <div class="row">
            <div class="col text-left">
                <h2>Listado de Productos</h2>
                <b-button size="sm" :to="{name:'CreateProduct'}" variant="success">Crear</b-button>
                <b-button size="sm" :to="{name:'Menu'}" variant="warning">Atras</b-button>
                <div class="col-md-12">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Valor Agregado</th>
                                <th>Prima USD</th>
                                <th>Accion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="product in products" :key="product.id">
                                <td>{{product.nombre}}</td>
                                <td>{{product.valorAsegurado}}</td>
                                <td>{{product.primaUsd}}</td>
                                <td>
                                    <b-button variant="primary" size="sm" :to ="{name:'EditProduct', params:{productId:product.id}}">Editar</b-button>
                                    <b-button variant="danger" size="sm" :to ="{name:'DeleteProduct', params:{productId:product.id}}">Eliminar</b-button>            
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import axios from 'axios'
export default {
    data(){
        return{
            fields:[
                {key: 'nombre', label:'Nombre'},
                {key: 'valorAsegurado', label:'Valor Asegurado'},
                {key: 'primaUsd', label:'Prima USD'},
                {key: 'action', label:'Accion'},
            ],
            products:[]
        }
    },
    methods: {
        getProducts(){
            const path='http://localhost:8080/api/v1/products'
            axios.get(path).then((response)=>{
                this.products = response.data
            })
            .catch((error)=>{
                console.log(error)
            })
        }
    },
    created() {
        this.getProducts();
    },
}
</script>
<style lang="">
    
</style>