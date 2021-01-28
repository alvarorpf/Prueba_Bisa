<template lang="html">
    <div class="container">
        <div class="row">
            <div class="col text-left">
                <h2>Listado de Polizas</h2>
                <b-button size="sm" :to="{name:'CreatePolicy'}" variant="success">Crear</b-button>
                <b-button size="sm" :to="{name:'Menu'}" variant="warning">Atras</b-button>
                <div class="col-md-12">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Paterno</th>
                                <th>Materno</th>
                                <th>Product Id</th>
                                <th>Valor Agregado</th>
                                <th>Prima USD</th>
                                <th>Vig.Inicio</th>
                                <th>Vig.Fin</th>
                                <th>Accion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="policy in policys" :key="policy.id">
                                <td>{{policy.nombre}}</td>
                                <td>{{policy.apPaterno}}</td>
                                <td>{{policy.apMaterno}}</td>
                                <td>{{policy.productId}}</td>
                                <td>{{policy.valorAsegurado}}</td>
                                <td>{{policy.primaUsd}}</td>
                                <td>{{policy.vigInicio}}</td>
                                <td>{{policy.vigFin}}</td>
                                <td>
                                    <b-button variant="primary" size="sm" :to ="{name:'EditPolicy', params:{policyId:policy.id}}">Editar</b-button>
                                    <b-button variant="danger" size="sm" :to ="{name:'DeletePolicy', params:{policyId:policy.id}}">Eliminar</b-button>            
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
                {key: 'apPaterno', label:'Paterno'},
                {key: 'apMaterno', label:'Materno'},
                {key: 'productId', label:'Producto ID'},
                {key: 'valorAsegurado', label:'Valor Asegurado'},
                {key: 'primaUsd', label:'Prima USD'},
                {key: 'vigInicio', label:'Vig. Inicio'},
                {key: 'vigFin', label:'Vig. Fin'},
            ],
            policys:[]
        }
    },
    methods: {
        getPolicys(){
            const path='http://localhost:8080/api/v1/policys'
            axios.get(path).then((response)=>{
                this.policys = response.data
            })
            .catch((error)=>{
                console.log(error)
            })
        }
    },
    created() {
        this.getPolicys();
    },
}
</script>
<style lang="">
    
</style>