<template>
  <div class="q-pa-md">
    <div class="q-col-lg-6 q-col-md-8 q-col-xs-12">
      <div class="q-pa-md q-gutter-md">
        <form @submit="login" class="q-mx-auto" style="max-width: 400px;">
          <h2 class="text-h4 q-mb-md">Login</h2>
          <p class="text-h6">Entre com seu email e senha, ou com sua conta do Google.</p>
          <q-input
            v-model="username"
            filled
            label="Username"
            class="q-mb-md"
          ></q-input>
          <q-input
            v-model="password"
            filled
            label="Password"
            type="password"
            class="q-mb-md"
          ></q-input>
          <div class="q-mt-md">
            <q-btn type="submit" color="primary" label="Login"></q-btn>
          </div>
        </form>
      </div>
    </div>
    <div class="q-col-lg-6 q-col-md-4 q-col-xs-12 q-flex q-items-center">
      <img src="../assets/img/login.jpg" alt="Imagem" class="responsive-img">
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    login(event) {
      event.preventDefault(); // Impede o envio do formulário
      // Lógica de autenticação aqui
      console.log('Realizando login...')
    }
  }
}
</script>

<style scoped>
.q-pa-md {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.q-col-lg-6,
.q-col-md-8,
.q-col-xs-12 {
  flex: 0 0 50%;
  max-width: 50%;
}

.q-flex {
  display: flex;
}

.q-items-center {
  align-items: center;
}

.responsive-img {
  width: 100%;
  height: auto;
}

.q-mb-md {
  margin-bottom: 20px;
}

.q-mt-md {
  margin-top: 20px;
}

.text-h6{
  font-size: 12px;
}
</style>
