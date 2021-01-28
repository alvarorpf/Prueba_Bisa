<template lang="html">
    <div class="container">
        <div class="row">
            <div class="col text-left">
                <h2>Editar Producto</h2>
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
                            <div class="rows">
                                <div class="col text-left">
                                    <b-button type="submit" variant="primary">Editar</b-button>
                                    <b-button type="submit" class="btn-large-space" :to="{name:'ListProduct'}">Cancelar</b-button>
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
            productId: this.$route.params.productId,
            form:{
                nombre:'',
                valorAsegurado: '',
                primaUsd: '',

            }
        }
    },
    methods: {
        onSubmit(event){
            event.preventDefault()
            const path = `http://localhost:8080/api/v1/products/${this.productId}`
            axios.put(path,this.form).then((response)=>{
                this.form.nombre = response.data.nombre
                this.form.valorAsegurado = response.data.valorAsegurado
                this.form.primaUsd = response.data.primaUsd
                swal("Producto actualizado correctamente!", "", "success");
            })
            .catch((error)=>{
                console.log(error)
            })
        },
        getProduct()
        {
            const path = `http://localhost:8080/api/v1/products/${this.productId}`
            axios.get(path).then((response)=>{
                this.form.nombre = response.data.nombre
                this.form.valorAsegurado = response.data.valorAsegurado
                this.form.primaUsd = response.data.primaUsd
            })
            .catch((error)=>{
                console.log(error)
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