function uLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  function u(E) {
    if (E.boolInvalid) {
      if (E.approvalStatus === Lt.PASS.V) return "已作废";
      if (E.approvalStatus === Lt.AUDITING.V) return "作废审批中";
    }
    return E.boolInApproval && E.approvalStatus === Lt.PASS.V ? "变更中" : Lt.VL[E.approvalStatus];
  }
  const r = o.flatMap((E) => {
    var y;
    return ((y = E == null ? void 0 : E.detailList) == null ? void 0 : y.map((b) => ({ ...E, ...b, monomerList: E.monomerList && E.monomerList.length > 0 ? E.monomerList.map((V) => V.name).join("、") : "全部单体", status: u({ ...E, ...b }) }))) || [];
  });
  return { header: e, table: r, footer: n, qrCode: c };
}
function cLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  var r, E;
  (r = e.monomer) != null && r.length ? e.monomerList = (E = e.monomer) == null ? void 0 : E.map((y) => y.name).join("、") : e.monomerList = "全部单体";
  const u = o.flatMap((y) => {
    var b;
    return ((b = y == null ? void 0 : y.detailList) == null ? void 0 : b.map((V) => ({ ...y, ...V }))) || [];
  });
  return { header: e, table: u, footer: n, qrCode: c };
}
function dLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => {
    const E = e.weightStatus === au.GROSS.V;
    return r.weight = E ? r.grossWeight : r.netWeight, r.totalWeight = E ? r.totalGrossNetWeight : r.totalNetWeight, r;
  });
  return { header: e, table: u, qrCode: c, footer: n };
}
async function mLe({ header: e, table: o, footer: n, qrCode: c }) {
  const { plantOutboundDetailList: u = [], plantReturnDetailList: r = [] } = o;
  u.length > 0 && u.forEach((y) => {
    y.type = "出库";
  }), r.length > 0 && r.forEach((y) => {
    y.mete = -y.mete, y.type = "退库";
  });
  const E = [...u, ...r];
  return await Qt(E), await Ut(E, void 0, { mete: ["mete", "rejectMete", "usedMete"], quantity: ["quantity", "rejectQuantity"], amount: ["avgUnitPrice", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight", "unitPriceNoFreight"] }), E.forEach((y) => {
    y.spec = Ki(y);
  }), { header: e, table: E, footer: n, qrCode: c };
}
const Ji = { productionLineMete: F5e, productionStatisticsMete: z5e, assembleNestingOrder: H5e, processMete: q5e, meteUnit: G5e, surfaceArea: iLe, projectSummary: J5e, projectConfig: X5e, unProducedMete: Q5e, unCompleteMete: Z5e, wageProducedMete: eLe, productSendReceiveStorage: $5e, wageCompleteMete: tLe, materialType: lLe, areaConvert: aLe, materialListType: oLe, shipmentDetailWidth: B5e, steelDosageFormat: nLe, structureOrderFormat: sLe, dataFormat: rLe, paintingCraftListPrintFormat: uLe, paintingCraftListDetailPrintFormat: cLe, mesShipMeteDetailFormat: dLe, lossStatisticsReceiveDetailFormat: mLe };
function pLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r = Ut({ data: r, basicClass: r.basicClass, precision: 5, field: ["value"], unit: ["unit"], returnNewObj: true, toNum: true }), r));
  return { header: e, table: u, footer: n, qrCode: c };
}
async function hLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  return await Qt(o), await Ut(o, void 0, { mete: ["actualTheoryWeight", "mete", "rejectMete", "usedMete"], quantity: ["quantity", "rejectQuantity"], amount: ["avgUnitPrice", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight", "unitPriceNoFreight"] }), o.forEach((u) => {
    u.spec = Ki(u);
  }), { header: e, table: o, footer: n, qrCode: c };
}
async function fLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  return await Qt(o), await fo(o, void 0, { mete: ["mete"], quantity: ["quantity"], amount: ["unitPrice", "unitPriceExcludingVat"] }), o.forEach((u) => {
    var r;
    u.wageQuotaType && (u.manufUnit = (r = Gi.V[u.wageQuotaType]) == null ? void 0 : r.unit);
  }), { header: e, table: o, footer: n, qrCode: c };
}
async function gLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  return o.forEach((u) => {
    u.supplementNo = u.serialNumber;
  }), await Qt(o), await Ut(o), o.forEach((u) => {
    u.spec = Ki(u);
  }), { header: e, table: o, footer: n, qrCode: c };
}
async function ELe({ header: e = {}, table: o = [], footer: n, qrCode: c }) {
  const u = JSON.parse(JSON.stringify(e)), r = u.source;
  let E = "", y = [];
  r && r.length > 0 && (r.forEach((M, g) => {
    let S = "";
    M && M.project ? S += M.project.shortName : S += "公共库", M.factory && (S += `（${M.factory.name}）`), y.push(S);
  }), y = Array.from(new Set(y)), E = y.join("　/　")), u.boolBorrowReturnNotSelf && u.borrowProject && (E += "　▶　", E += u.borrowProject.shortName), u.source = E;
  const b = u.direction;
  let V = "";
  if (b) {
    b.project ? V += b.project.shortName : V += "公共库";
    let M = "";
    b.factory && (M += `${b.factory.name} - `), b.warehouse && (M += `${b.warehouse.name}`), V += `（${M}）`;
  }
  return u.direction = V, await Qt(o), await Ut(o), o.forEach((M) => {
    M.spec = Ki(M);
  }), { header: u, table: o, footer: n, qrCode: c };
}
async function yLe({ header: e = {}, table: o = [], footer: n, qrCode: c }) {
  const u = JSON.parse(JSON.stringify(e)), r = u;
  let E = "";
  return r.directionWorkshop && (E += `${r.directionWorkshop} - `), r.directionWarehouse && (E += `${r.directionWarehouse}`), E && (u.destination = E), await Qt(o), await Ut(o), o.forEach((y) => {
    y.spec = Ki(y);
  }), { header: u, table: o, footer: n, qrCode: c };
}
async function TLe({ header: e = {}, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => {
    var E, y;
    return r.direction = r.directionWorkshop ? `${(E = r.directionWorkshop) == null ? void 0 : E.name} - ${(y = r.directionWarehouse) == null ? void 0 : y.name}` : "-", r;
  });
  return await Qt(o), await Ut(o), { header: e, table: u, footer: n, qrCode: c };
}
function _Le({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r = Ut({ data: r, basicClass: r.basicClass, field: ["value"], returnNewObj: true, toNum: true }), r));
  return { header: e, table: u, footer: n, qrCode: c };
}
function bLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.collectionRate = (r.collectionRate * 100).toFixed(2) + "%", r.invoiceRate = (r.invoiceRate * 100).toFixed(2) + "%", r));
  return { header: e, table: u, footer: n, qrCode: c };
}
async function VLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.projectFullName = `${r.project.serialNumber} ${r.project.name}`, r.totalLength = St(Be(r.totalLength, Ft.LENGTH_DP), Ft.LENGTH, "m"), r.totalWeight = St(Be(r.totalWeight, Ft.WEIGHT_DP), Ft.WEIGHT, "kg"), r.weight = St(Be(r.weight, Ft.WEIGHT_DP), Ft.WEIGHT, "kg"), r.totalArea = St(Be(r.totalArea, Ft.AREA_DP), Ft.AREA, "m²"), r));
  return { header: e, table: u, footer: n, qrCode: c };
}
async function wLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = [];
  return o.forEach((r) => {
    A(r.list) ? r.list.forEach((E) => {
      u.push(E);
    }) : u.push(r);
  }), await Qt(u), await Ut(u, void 0, { mete: ["actualTheoryWeight", "mete", "rejectMete", "usedMete"], quantity: ["quantity", "rejectQuantity"], amount: ["avgUnitPrice", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight", "unitPriceNoFreight"] }), u.forEach((r) => {
    r.spec = Ki(r);
  }), { header: e, table: u, footer: n, qrCode: c };
}
const Za = { preparesCustomSummary: pLe, checkUnitFormat: _Le, movingInventoryDetailsDataFormat: TLe, dataFormat: hLe, manufDataFormat: fLe, supplementDataFormat: gLe, transferDataFormat: ELe, movingInventoryDataFormat: yLe, scrapPurchaser: bLe, handleManufOutboundRecord: VLe, returnReportDataFormat: wLe };
function SLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.allDays = "", A(r.startDate) && A(r.endDate) && (r.allDays = sr(r.startDate, r.endDate)), A(r.structureQuantityWork) && (r.structureQuantityWork = St(r.structureQuantityWork, "kg", "t")), r));
  return { header: e, table: u, qrCode: c, footer: n };
}
function vLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.collectionRate *= 100, r.invoiceRate *= 100, r));
  return { header: e, table: u, qrCode: c, footer: n };
}
function RLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => {
    const E = r.amount || r.freight || 0;
    return r.paymentRate = E ? (r.paymentAmount || 0) / E * 100 : 0, r.invoiceRate = E ? (r.invoiceAmount || 0) / E * 100 : 0, r;
  });
  return { header: e, table: u, qrCode: c, footer: n };
}
function MLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.yearDepreciationRate = ji(r.yearDepreciationRate * 100, 2), r.monthDepreciationRate = ji(r.monthDepreciationRate * 100, 2), r));
  return { header: e, table: u, qrCode: c, footer: n };
}
function ALe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.proportion = ji(r.proportion * 100, 2), r));
  return { header: e, table: u, qrCode: c, footer: n };
}
function NLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.serialNumber ? r.orderName = r.serialNumber : (r.projectNameList = r.projectNameList || [], r.serialNumberList = r.serialNumberList || [], r.orderName = [...r.projectNameList, ...r.serialNumberList].join("、")), r));
  return { header: e, table: u, qrCode: c, footer: n };
}
function LLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.totalArea = St(r.totalArea, "mm2", "m2"), r));
  return { header: e, table: u, qrCode: c, footer: n };
}
function ILe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.type === 2 ? (r.projectOrName = r.paymentUnit, r.seller = r.collectionUnit, r.businessType = 9) : (r.projectOrName = r.project.name, r.seller = r.collectionUnit), r));
  return { header: e, table: u, qrCode: c, footer: n };
}
function CLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => {
    var E, y;
    return r.projects = (y = (E = r.projectList) == null ? void 0 : E.map((b) => di(b))) == null ? void 0 : y.join(","), r;
  });
  return { header: e, table: u, qrCode: c, footer: n };
}
function PLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.taxRate = r.taxRate || 0, r.type === 2 ? (r.projectOrName = r.paymentUnit, r.seller = r.collectionUnit, r.businessType = 9) : (r.projectOrName = r.project.name, r.seller = r.collectionUnit), r));
  return { header: e, table: u, qrCode: c, footer: n };
}
function OLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.grossProfitRate = ji(r.grossProfitRate * 100, 2), r));
  return { header: e, table: u, qrCode: c, footer: n };
}
function kLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.invoiceType === fi.RECEIPT.V ? r.invoiceType = `${fi.VL[r.invoiceType]}` : r.invoiceType = `${fi.VL[r.invoiceType]} ( ${r.taxRate} % )`, r));
  return console.log(u), { header: e, table: u, qrCode: c, footer: n };
}
function DLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.invoiceType === fi.RECEIPT.V ? r.invoiceType = `${fi.VL[r.invoiceType]}` : r.invoiceType = `${fi.VL[r.invoiceType]} ( ${r.taxRate} % )`, r));
  return console.log(u), { header: e, table: u, qrCode: c, footer: n };
}
function xLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.invoiceType === fi.RECEIPT.V ? r.invoiceType = `${fi.VL[r.invoiceType]}` : r.invoiceType = `${fi.VL[r.invoiceType]} ( ${r.taxRate} % )`, r));
  return console.log(u), { header: e, table: u, qrCode: c, footer: n };
}
function ULe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.invoiceType === fi.RECEIPT.V ? r.invoiceType = `${fi.VL[r.invoiceType]}` : r.invoiceType = `${fi.VL[r.invoiceType]} ( ${r.taxRate} % )`, r));
  return console.log(u), { header: e, table: u, qrCode: c, footer: n };
}
async function YLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  return e.mete = e.mete ? e.mete + e.meteUnit : "", await Qt(o, { multipleSpec: true }), await Ut(o, { toSmallest: false, toNum: true }, { mete: ["mete", "actualReceivedMete"], amount: ["price", "priceExcludingVat"] }), { header: e, table: o, footer: n, qrCode: c };
}
async function KLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  return e.mete = e.mete ? e.mete + e.meteUnit : "", o.forEach((u) => {
    u.basicClass = u.basicClassEnum;
  }), await Qt(o), await fo(o, { toSmallest: false, toNum: true }, { mete: ["mete"], amount: ["price", "priceExcludingVat"] }), { header: e, table: o, footer: n, qrCode: c };
}
function WLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = _e.state.config.dict, r = o.map((E) => (E.collectionReason = u.label.payment_reason[E.collectionReason], E));
  return { header: e, table: r, qrCode: c, footer: n };
}
const sa = { handleRate: vLe, handleAreaUnit: LLe, handleSupplierPaymentRate: RLe, durationCalculation: SLe, handleSupplierPaymentOrder: NLe, collectionLedger: ILe, paymentPurchaseOrderRecord: CLe, invoiceRecord: PLe, handleDepreciationRate: MLe, handleProportion: ALe, fabricatingCostStatisticsRate: OLe, selfExpendInvoiceDetailRate: kLe, stairUnitSupplierTicketDetailRate: DLe, secondUnitSelfInvoiceDetailRate: ULe, purchaseSupplierInvoiceDetailRate: xLe, newStorageDetailsRate: YLe, newStorageDetailsManufacturedRate: KLe, productCollectionRecord: WLe };
function jLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.orderName = r.name || r.supplierName, r));
  return { header: e, table: u, qrCode: c, footer: n };
}
async function FLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  var E, y;
  await Qt(o), await Ut(o);
  let u = Un();
  Ae(u) && (_e.dispatch("wms/fetchWmsConfig"), u = Un()), o.forEach((b) => {
    var V, M;
    b.projectName = b != null && b.project ? `${(V = b == null ? void 0 : b.project) == null ? void 0 : V.serialNumber} ${(M = b == null ? void 0 : b.project) == null ? void 0 : M.shortName}` : "-", b.spec = Ki(b);
  });
  const r = e != null && e.project ? `${(E = e == null ? void 0 : e.project) == null ? void 0 : E.serialNumber} ${(y = e == null ? void 0 : e.project) == null ? void 0 : y.shortName}` : "-";
  return { header: e, table: o, qrCode: c, footer: { projectName: r, remark: e.remark } };
}
async function zLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  return await Qt(o), await Ut(o, { toSmallest: false, toNum: true }, { amount: ["price"] }), { header: e, table: o, footer: n, qrCode: c };
}
async function BLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  var r, E;
  await Qt(o), o.forEach((y) => {
    y.totalLength = St(Be(y.totalLength, Ft.LENGTH_DP), Ft.LENGTH, "m"), y.totalWeight = St(Be(y.totalWeight, Ft.WEIGHT_DP), Ft.WEIGHT, "kg"), y.weight = St(Be(y.weight, Ft.WEIGHT_DP), Ft.WEIGHT, "kg"), y.totalArea = St(Be(y.totalArea, Ft.AREA_DP), Ft.AREA, "m²");
  });
  const u = e != null && e.project ? `${(r = e == null ? void 0 : e.project) == null ? void 0 : r.serialNumber} ${(E = e == null ? void 0 : e.project) == null ? void 0 : E.shortName}` : "-";
  return { header: e, table: o, qrCode: c, footer: { projectName: u, remark: e.remark } };
}
async function HLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  return o.forEach((u) => {
    var E, y, b;
    const r = Ra.getBits(Pe.ENUM, u.basicClass, "L");
    u.typeText = r.join(","), u.meteField = u.mete ? `${u.mete || ""} ${u.meteUnit || ""}` : "/", A(u.purchaseStatus) ? u.purchaseStatusName = u.purchaseStatus === 1 ? "采购中" : "已完成" : u.purchaseStatusName = "未采购", u.settlementStatus == sn.SETTLED.V ? u.dataStatusName = "已结算" : u.dataStatusName = rl.VL[u.dataStatus], A(u.projects) ? ((E = u.projects) == null || E.forEach((V) => {
      V.projectNameStr = di(V);
    }), u.projectNameStr = (b = (y = u.projects) == null ? void 0 : y.map((V) => V.projectNameStr)) == null ? void 0 : b.join("、")) : A(u.project) && (u.projectNameStr = di(u.project)), u.msgStr = Xa.VL[u.logisticsTransportType] + "【" + Bi.VL[u.logisticsPayerType] + "】";
  }), { header: e, table: o, qrCode: c, footer: n };
}
async function qLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  return await Qt(o), o.forEach((u) => {
    u.basicClass = u.basicClassEnum;
  }), await Ut(o, { toSmallest: false, toNum: true }, { amount: ["price"] }), { header: e, table: o, footer: n, qrCode: c };
}
async function GLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = { serialNumber: e == null ? void 0 : e.serialNumber, shortName: e == null ? void 0 : e.shortName, name: e == null ? void 0 : e.name };
  return await Qt(o), await Ut(o), { header: { ...e, project: u }, table: o, qrCode: c, footer: n };
}
async function QLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  return o.forEach((u) => {
    u.basicClass = u.basicClassEnum;
  }), await Qt(o), await fo(o, { toSmallest: false, toNum: true }, { mete: ["mete"], amount: ["price", "priceExcludingVat"] }), { header: e, table: o, footer: n, qrCode: c };
}
const In = { handleOrderName: jLe, handleRequisitionsRecord: FLe, storageFormatData: zLe, handleManufRequisitionsRecord: BLe, handleScmPurchaseDetail: HLe, purchaseDetailDimensions: qLe, handlePurchaseShippingList: GLe, purchaseDetailDimensionsProduct: QLe };
function ZLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.booleanlag = r.booleanlag ? "正常" : "滞后", r));
  return { header: e, table: u, qrCode: c, footer: n };
}
function JLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.amount = (r.totalLength || r.reportTotalLength || 0) / 1e3 * (r.price || 0), r));
  return { header: e, table: u, qrCode: c, footer: n };
}
const y2 = { handleProductionStatus: ZLe, handleProductionAmount: JLe };
async function XLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  return await Qt(o), o.forEach((u) => {
    u.productType === cr.RAW_MATERIAL.V && (Ut(u, void 0, { mete: ["mete", "actualReceivedMete"], quantity: ["quantity"] }), u.specification = Ki(u));
  }), { header: e, table: o, footer: n, qrCode: c };
}
async function $Le({ header: e, table: o = [], footer: n, qrCode: c }) {
  return o.forEach((u) => {
    u.totalLength = u.totalLength ? St(u.totalLength, "mm", "m", Ze.COM_L__M) : 0;
  }), e.totalLength = e.totalLength ? St(e.totalLength, "mm", "m", Ze.COM_L__M) : 0, { header: e, table: o, footer: n, qrCode: c };
}
