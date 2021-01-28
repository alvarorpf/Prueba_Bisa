<template lang="html">
    <div class="container">
        <div class="row">
            <div class="col">
                <h3>Esta seguro de eliminar esta poliza?</h3>
                <p>Nombre: {{this.element.nombre}}</p>
                <p>Paterno: {{this.element.apPaterno}}</p>
                <p>Materno: {{this.element.apMaterno}}</p>
                <p>ProductId: {{this.element.productId}}</p>
                <p>Valor Asegurado: {{this.element.valorAsegurado}}</p>
                <p>Prima USD: {{this.element.primaUsd}}</p>
                <p>Vig. Inicio: {{this.element.vigInicio}}</p>
                <p>Vig. Fin: {{this.element.vigFin}}</p>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <b-button v-on:click="deletePolicy" variant="danger">Eliminar</b-button>
                <b-button type="submit" class="btn-large-space" :to="{name:'ListPolicy'}">Cancelar</b-button>
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
            policyId: this.$route.params.policyId,
            element:{
                nombre: '',
                apPaterno:'',
                apMaterno:'',
                productId:'',
                valorAsegurado: '',
                primaUsd: '',
                vigInicio:'',
                vigFin:'',
            }
        }
    },
    methods: {
        getPolicy()
        {
            const path = `http://localhost:8080/api/v1/policys/${this.policyId}`
            axios.get(path).then((response)=>{
                this.element.nombre = response.data.nombre
                this.element.apPaterno = response.data.apPaterno
                this.element.apMaterno = response.data.apMaterno
                this.element.productId = response.data.productId
                this.element.valorAsegurado = response.data.valorAsegurado
                this.element.primaUsd = response.data.primaUsd
                this.element.vigInicio = response.data.vigInicio
                this.element.vigFin = response.data.vigFin
            })
            .catch((error)=>{
                console.log(error)
            })
        },
        deletePolicy(){
            const path = `http://localhost:8080/api/v1/policys/${this.policyId}`
            axios.delete(path).then((response)=>{
                swal("Poliza eliminada correctamente!", "", "success").then((response)=>{
                    location.href = '/policys'
                });
            })
            .catch((error)=>{
                swal("No es posible eliminar la poliza", "", "error")
            })
        }
    },
    created() {
        this.getPolicy();
    },
}
</script>
<style lang="">
    
</style>