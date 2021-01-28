<template lang="html">
    <div class="container">
        <div class="row">
            <div class="col text-left">
                <h2>Editar Poliza</h2>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <form @submit="onSubmit">
                            <div class="form-group row">
                                <label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
                                <div class="col-sm-6">
                                    <input type="text" placeholder ="Nombre" name="nombre" class="form-control" v-model.trim="form.nombre">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="apPaterno" class="col-sm-2 col-form-label">Paterno</label>
                                <div class="col-sm-6">
                                    <input type="text" placeholder ="Paterno" name="apPaterno" class="form-control" v-model.trim="form.apPaterno">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="apMaterno" class="col-sm-2 col-form-label">Materno</label>
                                <div class="col-sm-6">
                                    <input type="text" placeholder ="Materno" name="apMaterno" class="form-control" v-model.trim="form.apMaterno">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="productId" class="col-sm-2 col-form-label">ProductId</label>
                                <div class="col-sm-6">
                                    <input type="text" placeholder ="Producto ID" name="productId" class="form-control" v-model.trim="form.productId">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="valorAsegurado" class="col-sm-2 col-form-label">Valor Asegurado</label>
                                <div class="col-sm-6">
                                    <input type="text" placeholder ="Valor Asegurado" name="valorAsegurado" class="form-control" v-model.trim="form.valorAsegurado">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="primaUsd" class="col-sm-2 col-form-label">Prima USD</label>
                                <div class="col-sm-6">
                                    <input type="text" placeholder ="Prima USD" name="primaUsd" class="form-control" v-model.trim="form.primaUsd">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="vigInicio" class="col-sm-2 col-form-label">Vigencia Inicio</label>
                                <div class="col-sm-6">
                                    <input type="date" placeholder ="Vig. Inicio" name="vigInicio" class="form-control" v-model.trim="form.vigInicio">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="vigFin" class="col-sm-2 col-form-label">Vigencia Fin</label>
                                <div class="col-sm-6">
                                    <input type="date" placeholder ="Vig. Fin" name="vigFin" class="form-control" v-model.trim="form.vigFin">
                                </div>
                            </div>
                            <div class="rows">
                                <div class="col text-left">
                                    <b-button type="submit" variant="primary">Crear</b-button>
                                    <b-button type="submit" class="btn-large-space" :to="{name:'ListPolicy'}">Cancelar</b-button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import axios from 'axios'
import swal from 'sweetalert'
export default {
    data(){
        return{
            policyId: this.$route.params.policyId,
            form:{
                nombre:'',
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
        onSubmit(event){
            event.preventDefault()
            const path = `http://localhost:8080/api/v1/policys/${this.policyId}`
            axios.put(path,this.form).then((response)=>{
                this.form.nombre = response.data.nombre
                this.form.apPaterno = response.data.apPaterno
                this.form.apMaterno = response.data.apMaterno
                this.form.productId = response.data.productId
                this.form.valorAsegurado = response.data.valorAsegurado
                this.form.primaUsd = Date.parseDate(response.data.primaUsd,"yyyy-MM-dd");
                this.form.vigInicio = Date.parseDate(response.data.primaUsd,"yyyy-MM-dd");
                this.form.vigFin = response.data.vigFin
                swal("Poliza actualizado correctamente!", "", "success");
            })
            .catch((error)=>{
                console.log(error)
            })
        },
        getPolicy()
        {
            const path = `http://localhost:8080/api/v1/policys/${this.policyId}`
            axios.get(path).then((response)=>{
                this.form.nombre = response.data.nombre
                this.form.apPaterno = response.data.apPaterno
                this.form.apMaterno = response.data.apMaterno
                this.form.productId = response.data.productId
                this.form.valorAsegurado = response.data.valorAsegurado
                this.form.primaUsd = response.data.primaUsd
                this.form.vigInicio = response.data.vigInicio
                this.form.vigFin = response.data.vigFin
            })
            .catch((error)=>{
                console.log(error)
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