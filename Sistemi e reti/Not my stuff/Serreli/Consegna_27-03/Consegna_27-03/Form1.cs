using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Threading;

namespace Consegna_27_03
{
    public partial class frmCollisioni : Form
    {
        private int Dimensione = 0;
        private string scelta = "";
        private string StazioneTrasmittente = "";
        private string StazioneRicevente = "";
        private double time = 0;

        public frmCollisioni()
        {
            InitializeComponent();
        }

        private void btnA_Click(object sender, EventArgs e)
        {
            sceltaStazione(btnA.Text);
        }

        private void btnB_Click(object sender, EventArgs e)
        {
            sceltaStazione(btnB.Text);
        }

        private void btnC_Click(object sender, EventArgs e)
        {
            sceltaStazione(btnC.Text);
        }

        private void btnD_Click(object sender, EventArgs e)
        {
            sceltaStazione(btnD.Text);
        }

        private void btnE_Click(object sender, EventArgs e)
        {
            sceltaStazione(btnE.Text);
        }

        private void btnF_Click(object sender, EventArgs e)
        {
            sceltaStazione(btnF.Text);
        }

        private void btnG_Click(object sender, EventArgs e)
        {
            sceltaStazione(btnG.Text);
        }

        private void btnH_Click(object sender, EventArgs e)
        {
            sceltaStazione(btnH.Text);
        }

        private void btnI_Click(object sender, EventArgs e)
        {
            sceltaStazione(btnI.Text);
        }

        private void btnL_Click(object sender, EventArgs e)
        {
            sceltaStazione(btnL.Text);
        }

        private void rbtnStazioneTrasmittente_CheckedChanged(object sender, EventArgs e)
        {
            scelta = "trasmittente";
        }

        private void rbtnStazioneRicevente_CheckedChanged(object sender, EventArgs e)
        {
            scelta = "ricevente";
        }

        private void sceltaStazione(String stazione)
        {
            if (scelta == "trasmittente")
                StazioneTrasmittente = stazione;
            else
                StazioneRicevente = stazione;
        }

        private void btnCalcola_Click(object sender, EventArgs e)
        {
            if (ControlloCampi() == true) return;
            Dimensione = Int32.Parse(txtDimensione.Text);
            double RTD = (Dimensione / 200) * 2;
            time = new Random().NextDouble()*RTD*2;
            if (time >= RTD)
                lblRisultato.Text = "Non sono state trovate collisioni durante la trasmissione tra la stazione " + StazioneTrasmittente + " e la stazione " + StazioneRicevente;
            else
                lblRisultato.Text = "E' stata rilevata una collisione.";


            lblRTD.Text = "RTD : " + RTD + " microsecondi";
            lblTime.Text = "tempo rilevato : " + time.ToString();

        }

        private void lblStop_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private bool ControlloCampi()
        {
            bool errore = false;

            if (StazioneTrasmittente == "")
            {
                MessageBox.Show("Selezionare una stazione trasmittente!");
                errore = true;
            }
            if (StazioneRicevente == "")
            {
                MessageBox.Show("Selezionare una stazione ricevente!");
                errore = true;
            }
            if (txtDimensione.Text == "")
            {
                MessageBox.Show("Fornire dimensione della rete!");
                errore = true;
            }
            return errore;
        }

        
    }
}
