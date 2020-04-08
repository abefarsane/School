using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Consegna23_3
{
    public partial class Form1 : Form
    {
        private int Dimensione = 0; //Lunghezza della rete
        private string Trasmittente = ""; //Nome della stazione trasmittente
        private string Ricevente = ""; // Nome della stazione ricevente
        private double TempoCasuale = 0; //Valore generato casualmente
        //Clickando su una stazione se la variabile è 1 quella stazione sarà ricevente,
        //se invece la variabile è 0 la stazione è trasmittente.
        private int DecidiStazione = 0;

        public Form1()
        {
            InitializeComponent();
        }

        //Funzioni copiate da internet per contrallare se il carattere inserito è
        //un numero o no.
        //Crediti: http://www.dotnethell.it/tips/TextboxSolonumeri.aspx
        public bool IsNumeric(string numero)
        {
            try
            {
                Int32.Parse(numero);
                return true;
            }
            catch (FormatException)
            {
                return false;
            }
        }

        private void txtDimensioneRete_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!IsNumeric(e.KeyChar.ToString()) && (((int)e.KeyChar) != 8))
                e.Handled = true;
        }
        
        //Chiude il programma
        private void btnEsci_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        //Stta una delle due stazioni a seconda di quella scelta
        //e dello stato di DecidiStazione
        private void setStazione(string Nome)
        {
            if(DecidiStazione == 1)
            {
                Ricevente = Nome;
                radioBtnRicevente.Text = "Stazione ricevente: " + Nome;
            }
            else
            {
                Trasmittente = Nome;
                radioBtnTrasmittente.Text = "Stazione trasmittente: " + Nome;
            }
        }

        //Funzioni per il cambio di stato di DecidiStazione quando scelgo o la stazione
        //ricevente o trasmittente
        private void radioBtnTrasmittente_CheckedChanged(object sender, EventArgs e)
        {
            DecidiStazione = 0;
        }

        private void radioBtnRicevente_CheckedChanged(object sender, EventArgs e)
        {
            DecidiStazione = 1;
        }

        //Eventi alla scelta della stazione.
        //Nota: in caso dovessi clickare su questi bottoni prima di scegliere se settare
        //una stazione ricevente o trasmittente, di default verrà inizializzata come
        //stazione trasmittente perchè DecidiStazione è inizializzato a 0.
        private void btnHostA_Click(object sender, EventArgs e)
        {
            setStazione(btnHostA.Text);
        }

        private void btnHostB_Click(object sender, EventArgs e)
        {
            setStazione(btnHostB.Text);
        }

        private void btnHostC_Click(object sender, EventArgs e)
        {
            setStazione(btnHostC.Text);
        }

        private void btnHostD_Click(object sender, EventArgs e)
        {
            setStazione(btnHostD.Text);
        }

        private void btnHostE_Click(object sender, EventArgs e)
        {
            setStazione(btnHostE.Text);
        }

        private void btnHostF_Click(object sender, EventArgs e)
        {
            setStazione(btnHostF.Text);
        }

        private void btnHostG_Click(object sender, EventArgs e)
        {
            setStazione(btnHostG.Text);
        }

        private void btnHostH_Click(object sender, EventArgs e)
        {
            setStazione(btnHostH.Text);
        }

        private void btnHostI_Click(object sender, EventArgs e)
        {
            setStazione(btnHostI.Text);
        }

        private void btnHostJ_Click(object sender, EventArgs e)
        {
            setStazione(btnHostJ.Text);
        }

        private bool ciSonoErrori()
        {
            bool err = false; //Indica se ci sono errori nei dati inseriti.
            if (Trasmittente == "")
            {
                MessageBox.Show("Selezionare una stazione trasmittente!");
                err = true;
            }                
            if (Ricevente == "")
            {
                MessageBox.Show("Selezionare una stazione ricevente");
                err = true;
            }
            if (txtDimensioneRete.Text == "")
            {
                MessageBox.Show("Indicare la dimensione in metri della rete");
                err = true;
            }
            return err;
        }

        private void btnStart_Click(object sender, EventArgs e)
        {
            if (ciSonoErrori()) return; //Controllo se i dati sono stati inseriti correttamente
            Dimensione = Int32.Parse(txtDimensioneRete.Text); //Ricavo la dimensione della rete
            double RoundTripDelay = 2 * (Dimensione / 200); //Calcolo il Round Trip Delay in microsecondi
            Random random = new Random();
            TempoCasuale = random.NextDouble() * 2 * RoundTripDelay; //Calcolo il tempo casuale tra 0 e 2RTD
            lblTempoCasualeGenerato.Text = "È stato generato un tempo casuale di " + TempoCasuale + " s"; //Comunico il tempo casuale generato
            if (TempoCasuale >= RoundTripDelay)
            {
                //Comunico la collisione e il RTD
                lblCollisione.Text = "Si è verificata una collisione, il tempo generato è maggiore del RTD:" + RoundTripDelay + " us";
            }
            else
            {
                //Comunico l'operazione andata a buon fine e il RTD
                lblCollisione.Text = "Non si sono verificate collisioni, il tempoo generato è minore del RTD:" + RoundTripDelay + " us";
            }
        }
    }
}
