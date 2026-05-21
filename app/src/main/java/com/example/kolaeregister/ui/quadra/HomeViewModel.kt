package com.example.kolaeregister.ui.quadra

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kolaeregister.data.model.Venue
import com.example.kolaeregister.repository.VenueRepository

class VenueViewModel(private val repository: VenueRepository) : ViewModel() {

    private val _quadrasPerto = MutableLiveData<List<Venue>>()
    val quadrasPerto: LiveData<List<Venue>> = _quadrasPerto

    private val _quadrasMaisAvaliadas = MutableLiveData<List<Venue>>()
    val quadrasMaisAvaliadas: LiveData<List<Venue>> = _quadrasMaisAvaliadas

    fun carregarDadosHome() {
        Thread {
            try {
                var listaDoBanco = repository.getAllVenues()


                if (listaDoBanco.isEmpty()) {
                    val quadrasDeTeste = listOf(
                        Venue(
                            name = "Arena Kola Beach",
                            subtitle = "Beach Tennis & Futevôlei",
                            description = "Quadra de areia perfeita com estrutura completa de iluminação e duchas.",
                            imageUrl = "https://images.unsplash.com/photo-1595435934249-5df7ed86e1c0?q=80&w=500",
                            location = "A 500m de você - SP",
                            pricePerHour = 90.0,
                            rating = 4.4,
                            numberRatings = 128,
                            owner = "Carlos Silva",
                            imgOwnerUrl = "https://images.unsplash.com/photo-1534528741775-53994a69daeb?q=80&w=150", // Foto de perfil real
                            monthsOnApp = 14
                        ),
                        Venue(
                            name = "Kola Society Club",
                            subtitle = "Futebol Society Premium",
                            description = "Grama sintética padrão FIFA de alta qualidade com vestiários modernos.",
                            imageUrl = "https://images.unsplash.com/photo-1517649763962-0c623066013b?q=80&w=500",
                            location = "A 1.2 km de você - SP",
                            pricePerHour = 120.0,
                            rating = 4.2,
                            numberRatings = 84,
                            owner = "Marcos Oliveira",
                            imgOwnerUrl = "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?q=80&w=150",
                            monthsOnApp = 8
                        ),
                        Venue(
                            name = "Kola Padel Center",
                            subtitle = "Quadras de Vidro Cobertas",
                            description = "Quadras panorâmicas de vidro cobertas, ideais para a prática de Padel faça chuva ou faça sol.",
                            imageUrl = "https://images.unsplash.com/photo-1626224583764-f87db24ac4ea?q=80&w=500",
                            location = "A 1.8 km de você - SP",
                            pricePerHour = 110.0,
                            rating = 4.5,
                            numberRatings = 95,
                            owner = "Fernanda Souza",
                            imgOwnerUrl = "https://images.unsplash.com/photo-1494790108377-be9c29b29330?q=80&w=150",
                            monthsOnApp = 22
                        ),
                        Venue(
                            name = "Ginásio Poliesportivo Kola",
                            subtitle = "Futsal, Vôlei e Basquete",
                            description = "Quadra de taco polida oficial para modalidades de salão.",
                            imageUrl = "https://images.unsplash.com/photo-1546519638-68e109498ffc?q=80&w=500",
                            location = "São Bernardo - SP",
                            pricePerHour = 150.0,
                            rating = 4.9,
                            numberRatings = 310,
                            owner = "Roberto Alves",
                            imgOwnerUrl = "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?q=80&w=150",
                            monthsOnApp = 36
                        ),
                        Venue(
                            name = "Kola Tennis Academy",
                            subtitle = "Quadras de Saibro Profissionais",
                            description = "Quadras oficiais de saibro, conta com restaurante e professores credenciados.",
                            imageUrl = "https://images.unsplash.com/photo-1554068865-24cecd4e34b8?q=80&w=500",
                            location = "Santo André - SP",
                            pricePerHour = 140.0,
                            rating = 4.8,
                            numberRatings = 190,
                            owner = "Bruno Henrique",
                            imgOwnerUrl = "https://images.unsplash.com/photo-1560250097-0b93528c311a?q=80&w=150",
                            monthsOnApp = 18
                        ),
                        Venue(
                            name = "Vila Kola Futebol",
                            subtitle = "Campo Society & Churrasco",
                            description = "Estrutura ideal para o futebol de final de semana com os amigos, com churrasqueira integrada.",
                            imageUrl = "https://images.unsplash.com/photo-1579952363873-27f3bade9f55?q=80&w=500",
                            location = "São Caetano - SP",
                            pricePerHour = 160.0,
                            rating = 4.7,
                            numberRatings = 240,
                            owner = "Ricardo Santos",
                            imgOwnerUrl = "https://images.unsplash.com/photo-1519085360753-af0119f7cbe7?q=80&w=150",
                            monthsOnApp = 5
                        )
                    )

                    repository.saveVenues(quadrasDeTeste)
                    listaDoBanco = repository.getAllVenues()
                }




                val perto = listaDoBanco.take(3)
                _quadrasPerto.postValue(perto)

                val maisAvaliadas = listaDoBanco.sortedByDescending { it.rating }.take(3)
                _quadrasMaisAvaliadas.postValue(maisAvaliadas)

            } catch (e: Exception) {
                android.util.Log.e("VENUE_VM", "Erro ao carregar dados: ${e.message}")
            }
        }.start()
    }
}

class VenueViewModelFactory(private val repository: VenueRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VenueViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return VenueViewModel(repository) as T
        }
        throw IllegalArgumentException("Classe ViewModel desconhecida")
    }
}