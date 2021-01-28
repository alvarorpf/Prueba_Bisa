<template lang="html">
    <div class="container">
        <div class="row">
            <div class="col">
                <h3>Esta seguro de eliminar este producto?</h3>
                <p>Nombre: {{this.element.nombre}}</p>
                <p>Valor Asegurado: {{this.element.valorAsegurado}}</p>
                <p>Prima USD: {{this.element.primaUsd}}</p>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <b-button v-on:click="deleteProduct" variant="danger">Eliminar</b-button>
                <b-button type="submit" class="btn-large-space" :to="{name:'ListProduct'}">Cancelar</b-button>
            </div>
        </div>
    </div>
</template>
<script>
import axios from 'axios'
import swal from 'sweetalert'
export default {
    data() {
        return {
            productId: this.$route.params.productId,
            element:{
                nombre: '',
                valorAsegurado: '',
                primaUsd: '',
            }
        }
    },
    methods: {
        getProduct()
        {
            const path = `http://localhost:8080/api/v1/products/${this.productId}`
            axios.get(path).then((response)=>{
                this.element.nombre = response.data.nombre
                this.element.valorAsegurado = response.data.valorAsegurado
                this.element.primaUsd = response.data.primaUsd
            })
            .catch((error)=>{
                console.log(error)
            })
        },
        deleteProduct(){
            const path = `http://localhost:8080/api/v1/products/${this.productId}`
            axios.delete(path).then((response)=>{
                swal("Producto eliminado correctamente!", "", "success").then((response)=>{
                    location.href = '/products'
                });
            })
            .catch((error)=>{
                swal("No es posible eliminar el libro", "", "error")
            })
        }
    },
    created() {
        this.getProduct();
    },
}
</script>
<style lang="">
    
</style>