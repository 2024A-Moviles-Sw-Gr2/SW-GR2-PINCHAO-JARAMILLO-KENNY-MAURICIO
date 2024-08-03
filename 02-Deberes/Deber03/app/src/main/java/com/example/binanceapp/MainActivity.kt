package com.example.binanceapp

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.binanceapp.adaptors.BotonAdapter
import com.example.binanceapp.adaptors.BotonData
import com.example.binanceapp.adaptors.DataItem
import com.example.binanceapp.adaptors.TableAdapter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inicializarRecyclerView()
        inicializarTablaView()
    }

    private fun inicializarTablaView() {
        val recyclerView: RecyclerView = findViewById(R.id.rv_tabla_monedas)
        val dataList = listOf(
            DataItem("Bitcoin", "$25,000", "+2.5%"),
            DataItem("Ethereum", "$1,600", "-1.2%"),
            DataItem("Ripple", "$0.45", "+3.0%"),
            DataItem("Cardano", "$1.20", "+1.5%"),
            DataItem("Litecoin", "$130", "+4.0%"),
            DataItem("Chainlink", "$20", "-0.8%"),
            DataItem("Polkadot", "$25", "+3.2%"),
            DataItem("Stellar", "$0.30", "-2.1%"),
            DataItem("Uniswap", "$22", "+5.0%"),
            DataItem("Dogecoin", "$0.10", "+10.0%"),
            DataItem("Solana", "$150", "-5.5%"),
            DataItem("VeChain", "$0.08", "+2.8%"),
            DataItem("Avalanche", "$50", "-1.3%"),
            DataItem("Shiba Inu", "$0.00003", "+15.0%"),
            DataItem("Polygon", "$1.40", "+2.2%"),
            DataItem("Aave", "$300", "-4.5%"),
            DataItem("Cosmos", "$40", "+6.3%"),
            DataItem("Tezos", "$4.50", "+0.5%"),
            DataItem("Theta", "$6.00", "-3.7%"),
            DataItem("IOTA", "$1.00", "+1.0%"),
            DataItem("NEO", "$50", "-2.0%"),
            DataItem("Binance Coin", "$350", "+1.9%"),
            DataItem("Tron", "$0.06", "+3.6%"),
            DataItem("Dash", "$200", "-0.7%"),
            DataItem("Zcash", "$120", "+2.0%"),
            DataItem("Maker", "$3,000", "-1.1%"),
            DataItem("Monero", "$250", "+0.2%"),
            DataItem("Compound", "$400", "-2.9%"),
            DataItem("Algorand", "$1.10", "+4.1%"),
            DataItem("Kusama", "$200", "-5.0%"),
            DataItem("Bitcoin Cash", "$500", "+1.7%"),
            DataItem("Elrond", "$150", "-3.3%"),
            DataItem("SushiSwap", "$10", "+7.0%"),
            DataItem("Celo", "$4.00", "+2.4%"),
            DataItem("Hedera", "$0.25", "-0.5%"),
            DataItem("Filecoin", "$40", "+0.9%"),
            DataItem("Holo", "$0.01", "+5.6%"),
            DataItem("Enjin Coin", "$1.50", "-1.8%"),
            DataItem("PancakeSwap", "$15", "+2.3%"),
            DataItem("Yearn Finance", "$30,000", "+0.1%"),
            DataItem("1inch", "$2.50", "-2.6%"),
            DataItem("Qtum", "$10", "+3.4%"),
            DataItem("Harmony", "$0.20", "+4.8%"),
            DataItem("Chiliz", "$0.30", "-0.4%"),
            DataItem("Decentraland", "$0.80", "+6.0%"),
            DataItem("Enzyme", "$100", "-1.5%")
        )


        val adapter = TableAdapter(dataList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun inicializarRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rv_menu_botones)

        // Crear una lista de datos para el RecyclerView
        val datos = listOf(
            BotonData(
                "Referido",
                """<svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><path fill="#e9e9f1" d="M9 14c1.381 0 2.631-.56 3.536-1.465C13.44 11.631 14 10.381 14 9s-.56-2.631-1.464-3.535C11.631 4.56 10.381 4 9 4s-2.631.56-3.536 1.465C4.56 6.369 4 7.619 4 9s.56 2.631 1.464 3.535A4.985 4.985 0 0 0 9 14m0 7c3.518 0 6-1 6-2c0-2-2.354-4-6-4c-3.75 0-6 2-6 4c0 1 2.25 2 6 2m12-9h-2v-2a1 1 0 1 0-2 0v2h-2a1 1 0 1 0 0 2h2v2a1 1 0 1 0 2 0v-2h2a1 1 0 1 0 0-2"/></svg>"""  ),
            BotonData(
                "Earn",
                """<svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 16 16"><path fill="#e9e9f1" d="M15.93 7.75a1.25 1.25 0 0 0-.3-.51a.833.833 0 0 0-.394-.238c.074.117.141.252.191.396c.056.147.092.304.103.467a1.784 1.784 0 0 1 0 .424a1.005 1.005 0 0 0-.142-.292a1.193 1.193 0 0 0-.48-.383a.938.938 0 0 0-1.195.382c-.05.082-.09.171-.12.266c-1.182-1.968-3.309-3.271-5.741-3.271c-.124 0-.247.003-.369.01a8.217 8.217 0 0 0-2.231.313C5.19 4.88 4.62 4 2 4l.8 2.51a5.207 5.207 0 0 0-1.247 1.465L0 8s-.17 4 1 4h.54a5.276 5.276 0 0 0 1.445 1.589L3 16h1.08C5.39 16 6 16 6 15.25v-.39a8.256 8.256 0 0 0 3.051-.008L9 15.25c0 .75.62.75 1.94.75H12v-2.39a4.79 4.79 0 0 0 1.903-2.717c.057-.027.114-.024.172-.024s.115-.003.172-.01c.251-.046.48-.144.679-.283a1.65 1.65 0 0 0 .591-.765c.028-.093.049-.191.063-.292l.001-.01c.221-.262.372-.59.419-.951a1.776 1.776 0 0 0-.072-.822zm-12.42 0a.75.75 0 1 1 0 1.5a.75.75 0 0 1 0-1.5M5.88 7a.502.502 0 0 1-.599-.247a.39.39 0 0 1 .296-.503a8.024 8.024 0 0 1 2.009-.22l.101-.001c.672 0 1.324.08 1.949.232c.126.024.262.182.262.372a.385.385 0 0 1-.019.119a.483.483 0 0 1-.346.247H9.38a7.198 7.198 0 0 0-1.706-.2h-.089c-.605 0-1.193.073-1.756.211zm8.7 2.93a1.16 1.16 0 0 1-.453.199L14 10.13v-.44c.165.125.374.2.6.2h.021zm.08-.68a.44.44 0 0 1-.459-.248a.607.607 0 0 1 .001-.566a.332.332 0 0 1 .43-.096a.48.48 0 0 1 .308.448v.001a1.457 1.457 0 0 1-.001.418a1.26 1.26 0 0 1-.282.022zM8 3H7v-.17h.25V1.74H7l.55-.55h.2v1.64H8z"/><path fill="#e9e9f1" d="M7.5.75a1.5 1.5 0 1 1-.001 3.001A1.5 1.5 0 0 1 7.5.75m0-.75a2.25 2.25 0 1 0 0 4.5a2.25 2.25 0 0 0 0-4.5"/></svg>"""
            ),
            BotonData(
                "Copy Trading",
                """<svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><path fill="#e9e9f1" d="M15.24 2h-3.894c-1.764 0-3.162 0-4.255.148c-1.126.152-2.037.472-2.755 1.193c-.719.721-1.038 1.636-1.189 2.766C3 7.205 3 8.608 3 10.379v5.838c0 1.508.92 2.8 2.227 3.342c-.067-.91-.067-2.185-.067-3.247v-5.01c0-1.281 0-2.386.118-3.27c.127-.948.413-1.856 1.147-2.593c.734-.737 1.639-1.024 2.583-1.152c.88-.118 1.98-.118 3.257-.118h3.07c1.276 0 2.374 0 3.255.118A3.601 3.601 0 0 0 15.24 2"/><path fill="#e9e9f1" d="M6.6 11.397c0-2.726 0-4.089.844-4.936c.843-.847 2.2-.847 4.916-.847h2.88c2.715 0 4.073 0 4.917.847c.843.847.843 2.21.843 4.936v4.82c0 2.726 0 4.089-.843 4.936c-.844.847-2.202.847-4.917.847h-2.88c-2.715 0-4.073 0-4.916-.847c-.844-.847-.844-2.21-.844-4.936z"/></svg>"""
            ),
            BotonData(
                "Mas",
                """<svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 14 14"><path fill="#e9e9f1" fill-rule="evenodd" d="M4.88 0a1 1 0 0 0-1 1v4.25a1 1 0 0 0 1 1h4.25a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1zM1 7.75a1 1 0 0 0-1 1V13a1 1 0 0 0 1 1h4.25a1 1 0 0 0 1-1V8.75a1 1 0 0 0-1-1zm6.75 1a1 1 0 0 1 1-1H13a1 1 0 0 1 1 1V13a1 1 0 0 1-1 1H8.75a1 1 0 0 1-1-1z" clip-rule="evenodd"/></svg>"""
            ),

        )

        // Configurar el adaptador
        val adaptador = BotonAdapter(datos) { label ->
            // Manejar el clic en el botón
            handleButtonClick(label)
        }

        // Configurar el RecyclerView
        recyclerView.adapter = adaptador
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Configurar el LayoutManager para disposición horizontal
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Establecer el espaciado automático
        val spacing = resources.getDimensionPixelSize(R.dimen.item_spacing) // Espacio en píxeles
        recyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                outRect.right = spacing
                if (parent.getChildAdapterPosition(view) == 0) {
                    outRect.left = spacing
                }
            }
        })
    }

    private fun handleButtonClick(label: String) {
        // Implementa la acción que deseas realizar cuando se haga clic en un botón
    }
}
