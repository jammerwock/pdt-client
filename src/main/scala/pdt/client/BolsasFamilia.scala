package pdt.client

import io.circe.generic.auto._
import pdt.client.decoders.localDateDecoder
import pdt.client.HttpClient.{HttpClient, get}
import pdt.domain._
import pdt.implicits.HttpRequestOps
import zio.RIO

object BolsasFamilia {

  def by(request: DisponivelPorCpf): RIO[HttpClient, List[BolsaFamilia]] =
    get[BolsaFamilia]("bolsa-familia-disponivel-por-cpf-ou-nis", request.parameters)

  def by(request: DisponivelPorNis): RIO[HttpClient, List[BolsaFamilia]] =
    get[BolsaFamilia]("bolsa-familia-disponivel-por-cpf-ou-nis", request.parameters)

  def by(request: BolsaFamiliaRequest): RIO[HttpClient, List[BolsaFamilia]] =
    get[BolsaFamilia]("bolsa-familia-por-municipio", request.parameters)

  def by(request: SacadoPorNis): RIO[HttpClient, List[BolsaFamilia]] =
    get[BolsaFamilia]("bolsa-familia-sacado-por-nis", request.parameters)
}