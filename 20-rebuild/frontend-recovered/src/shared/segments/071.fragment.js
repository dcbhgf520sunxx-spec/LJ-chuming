function _5e(e) {
  const o = e.header, n = o.fields, c = u6(o);
  A(n) && n.forEach((u) => {
    let r = "overflow: hidden;text-overflow: ellipsis;white-space: nowrap;";
    A(u.width) ? r += `width:${u.width}${e.unit};` : A(u.maxWidth) && (r += `max-width:${u.maxWidth}${e.unit};`), A(c) && (r += `height:${c}${e.unit};`), u.style = r;
  });
}
function b5e(e) {
  const o = e.footer, n = o.fields, c = u6(o);
  A(n) && n.forEach((u) => {
    let r = "";
    A(u.width) ? r += `width:${u.width}${e.unit};` : A(u.maxWidth) && (r += `max-width:${u.maxWidth}${e.unit};`), A(u.align) && (r += `text-align:${kn(u.align)};`), A(c) && (r += `height:${c}${e.unit};`), u.style = r;
  });
}
function u6(e) {
  const o = e.width, n = e.fields.filter((y) => A(y.show) ? y.show : true);
  let c = 1, u = 0;
  const r = e.size * 1.5 * 0.3528;
  A(n) && n.forEach((y) => {
    A(y.width) && (u += y.width), u > o && (c++, u = y.width);
  });
  const E = e.height / c;
  return (E < r ? r : E) - 2;
}
function Rd({ row: e = {}, val: o, field: n, emptyVal: c = "" }) {
  switch (n.source === i.CUSTOMIZE.V && (c = ""), Ae(o) && A(e) && A(n) && (o = d6(e, n.key)), n.type) {
    case a.PROJECT.K:
      return Si(w5e(o, n.format), c);
    case a.DATE.K:
      return Si(eV(o, n.format), c);
    case a.DATES.K:
      return Si(eV(o, n.format), c);
    case a.AMOUNT.K:
      return Si(S5e(o, n.format), c);
    case a.WEIGHT.K:
      return Si(v5e(o, n.format), c);
    case a.LENGTH.K:
      return Si(R5e(o, n.format), c);
    case a.RATE.K:
      return Si(L5e(o, n.format), c);
    case a.THICKNESS.K:
      return Si(M5e(o, n.format), c);
    case a.METE.K:
      return Si(A5e({ val: o, row: e, format: n.format }), c);
    case a.QUANTITY.K:
      return Si(N5e(o, n.format), c);
    case a.ENUM.K:
      return Si(V5e(o, n.format), c);
    case a.IMAGE.K:
      return `<img style="width:95%;height:95%;" src="${o || ""}"/>`;
    default:
      return Si(o, c);
  }
}
function V5e(e, o) {
  if (A(o) && A(o.enum) && A(vn[o.enum]) && A(e)) {
    const c = o.key || "L", u = vn[o.enum];
    if (o.bit) {
      const r = Ra.toArr(u), E = [];
      return r.forEach((y) => {
        y.V & e && E.push(y[c] || y.L);
      }), E.join("/");
    } else {
      const r = Ra.key2val(u);
      return A(r) && A(r[e]) ? r[e][c] || r[e].L : "";
    }
  }
}
function w5e(e, o = {}) {
  return Ae(o) && (o = { showProjectFullName: false, showSerialNumber: false, projectNameShowConfig: nt.SERIAL_NUMBER_START.V }), di(e, o, o.lineBreak);
}
function eV(e, o = "YY/MM/DD") {
  const n = (c) => {
    if (A(c)) return $a(+c).format(o);
  };
  if (typeof e == "string" && (e = e.split(","), e instanceof Array)) {
    if (e.length === 1) return n(e[0]);
    if (e.length > 1) return e.map((c) => n(c)).join("，");
  }
  if (e instanceof Array) {
    if (e.length === 1) return n(e[0]);
    if (e.length === 2) {
      const c = n(e[0]), u = n(e[1]);
      return `${c} ~ ${u}`;
    }
  }
  return n(e);
}
function S5e(e, o = {}) {
  if (A(e) && !isNaN(Number(e))) {
    let n = Number(e);
    return A(o.unit) && o.unit === We.WAN.V && (n /= 1e4), A(o.precision) && (n = n.toFixed(o.precision)), o.toThousand && (n = Mi(n, o.precision ?? Lr)), n;
  }
  return e;
}
function v5e(e, o = {}) {
  let n = e;
  return A(n) && (A(o.unit) && (n = St(n, rt.WEIGHT, o.unit)), A(o.precision) && (n = (+n).toFixed(o.precision)), o.toThousand && (n = Mi(n, o.precision ?? Lr))), n;
}
function R5e(e, o = {}) {
  let n = e;
  return A(n) && (A(o.unit) && (n = St(n, rt.LENGTH, o.unit)), A(o.precision) && (n = (+n).toFixed(o.precision)), o.toThousand && (n = Mi(n, o.precision ?? Lr))), n;
}
function M5e(e, o = {}) {
  let n = e;
  return A(n) && (A(o.unit) && (n = St(n, Ft.THICKNESS, o.unit)), A(o.precision) && (n = (+n).toFixed(o.precision)), o.toThousand && (n = Mi(n, o.precision ?? Lr))), n;
}
function A5e({ val: e, row: o, format: n = {} }) {
  let c = e;
  return A(c) && (A(n.precision) && (c = (+c).toFixed(n.precision)), n.toThousand && (c = Mi(c, n.precision ?? Lr)), n.showUnit && (n.unit && (c += ` ${n.unit}`), o != null && o[n.rowUnit] && (c += ` ${o[n.rowUnit]}`))), c;
}
function N5e(e, o = {}) {
  let n = e;
  return A(n) && (A(o.precision) && (n = (+n).toFixed(o.precision)), o.toThousand && (n = Mi(n, o.precision ?? Lr))), n;
}
function L5e(e, o = {}) {
  let n = e;
  return A(o.precision) && (n = (+n).toFixed(o.precision)), n + "%";
}
function c6(e) {
  switch (e) {
    case D.TOP.V:
      return "top:0;";
    case D.BOTTOM.V:
      return "bottom:0;";
    case D.CENTER.V:
      return "top: 50%;transform: translateY(-50%);";
    default:
      return "top:0;";
  }
}
function kn(e) {
  switch (e) {
    case t.LEFT.V:
      return "left";
    case t.RIGHT.V:
      return "right";
    case t.CENTER.V:
      return "center";
    default:
      return "left";
  }
}
function I5e(e) {
  let o = "";
  switch (e) {
    case ke.DEFAULT.V:
      o = "<span tdata='pageNO'>##</span> / <span tdata='pageCount'>##</span>";
      break;
    case ke.ONE.V:
      o = "<span tdata='pageNO'>第##页</span> / <span tdata='pageCount'>共##页</span>";
      break;
    case ke.TWO.V:
      o = "<span tdata='pageNO' format='ChineseNum'>第##页</span> / <span tdata='pageCount' format='ChineseNum'>共##页</span>";
      break;
    default:
      o = "<span tdata='pageNO'>##</span> / <span tdata='pageCount'>##</span>";
  }
  return o;
}
function d6(e, o) {
  if (A(e) && A(o) && typeof o == "string") {
    const c = o.split(".");
    return c.length === 1 ? e[c[0]] : c.reduce((u, r) => uo.isPlainObject(u) ? u[r] : void 0, e);
  }
}
const Ir = `
<style>
body {
    /* font-feature-settings: 'onum' 1; */
    color: #333;
   /*  overflow: hidden;*/
    text-rendering: optimizeLegibility;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    font-family: AvenirNext,Avenir,-apple-system,BlinkMacSystemFont,Roboto Slab,Droid Serif,Segoe UI,Oxygen-Sans,Ubuntu,Cantarell,Georgia,serif;
    line-height: 1.15;
}
</style>
`, m6 = Ir + `
<style>
.header-content {
  font-family: lucida sans unicode,lucida grande,Sans-Serif;
  width: 100%;
  box-sizing: border-box;
  overflow: hidden;
  line-height: 1.15;
  margin-bottom: 1mm;
}
.header-content-item {
  margin: 1mm 0;
  /*float: left;*/
  display: inline-block;
  position: relative;
  text-align: left;
  /* padding-right: 5mm; */
  box-sizing: border-box;
  overflow : hidden;
  text-overflow: ellipsis;
  white-space: nowrap;

  /* 为了兼容 IE6，使用 *display: inline; */
  *display: inline;
  *zoom: 1;
}
.header-content :first-child {
  margin-top: 0;
}
</style>
`, C5e = Ir + `
<style>
.title-content {
  width: 100%;
  box-sizing: border-box;
  text-align: center;
  font-size: 17pt;
  font-weight: bold;
}
</style>
`, P5e = Ir + `
<style>
.table-content {
  word-break: break-all;
  box-sizing: border-box;
  width: fit-content;
  margin: 1mm 0;
}
td{ 
  border:1px solid #000;
}
.print-table {
    font-family: lucida sans unicode,lucida grande,Sans-Serif;
    font-size: 9pt;
    border-collapse: collapse;
    /* border-top: 1px solid #9baff1; */
    /* border-bottom: 1px solid #9baff1; */
    width: 100%;
}
.print-table .blank-column {
  min-width: 0;
  border: none;
  display: table-column;
}
.print-table .blank-column >div{
  display: inline-table;
  min-width: 0;
}
.print-table tbody .td {
  /* font-size: 9pt; */
  /* border-right: 1px solid #aabcfe; */
  /* border-left: 1px solid #aabcfe; */
  /* color: #669; */
  padding: 0;
  line-height:13pt;
  white-space: pre-wrap;
}
.print-table tbody .td >div {
  padding: 0 1mm;
  box-sizing: border-box;
  min-height: 3mm;
}
.print-table .th {
    /* font-size: 10pt; */
    font-weight: 400;
    line-height: 15pt;
    /* background: #e8edff; */
    /* border-right: 1px solid #9baff1; */
    /* border-left: 1px solid #9baff1; */
    /* color: #039; */
    padding: 0;
}
.print-table .th >div {
  padding: 0 1mm;
  box-sizing: border-box;
  min-height: 3mm;
}
tbody tr:last-child{
  border-bottom:none
}
</style>
`, O5e = Ir + `
<style>
.tip {
  margin: 1mm 0;
  white-space: pre-line;
  display: inline-block;
  width: 100%;
  font-size: 9pt;
  color: red;
}
.footer-content{
  font-family: lucida sans unicode,lucida grande,Sans-Serif;
  overflow: hidden;
  width: 100%;
  box-sizing: border-box;
  line-height: 1.15;
  /* margin-bottom: 3mm;*/
}
.footer-content-item {
  margin: 1mm 0;
  /*float: left;*/
  display: inline-block;
  position: relative;
  /* padding-right: 5mm; */
  box-sizing: border-box;
  overflow : hidden;
  text-overflow: ellipsis;
  white-space: nowrap;

  /* 为了兼容 IE6，使用 *display: inline; */
  *display: inline;
  *zoom: 1;
}
</style>
`, k5e = Ir + `
<style>
.page-content {
  box-sizing: border-box;
  border: none;
  width: 100%;
  position: absolute;
  bottom: 0;
  left: 0;
}
</style>
`, D5e = `
<style>
.logo-content {

}
</style>
`;
function x5e({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r = Ut({ data: r, enclosureSettlementType: e && e.enclosureSettlementType, basicClass: r.basicClass, precision: 5, returnNewObj: true, toNum: true }), r));
  return { header: e, table: u, qrCode: c, footer: n };
}
function U5e({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.filter((r) => !(r.storageMete === 0 && r.beginInventory === 0 && r.currentInventory === 0 && r.outboundMete === 0));
  return { header: e, table: u, qrCode: c, footer: n };
}
function Y5e({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.taxRate = r.taxRate || 0, r));
  return { header: e, table: u, qrCode: c, footer: n };
}
function K5e({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.taxRate = r.taxRate || 0, r.type === 2 ? (r.projectOrName = r.contractWaste.purchaser, r.seller = r.collectionUnit, r.businessType = 9) : (r.projectOrName = r.project.name, r.seller = r.collectionUnit), r));
  return { header: e, table: u, qrCode: c, footer: n };
}
const p6 = { meteWithUnit: x5e, filter: U5e, handleTaxRate: Y5e, handleContractTaxRate: K5e };
function zs({ productType: e, w_unit: o = "t", l_unit: n = "m", isSingle: c = false }) {
  const u = { t: "COM_WT__T", kg: "COM_WT__KG", m: "COM_L__M", mm: "COM_L__MM" }, r = { t: "吨", kg: "千克", m: "米", mm: "毫米" }, E = u[o], y = u[n];
  return { [li.ARTIFACT.V]: { label: c ? "单重" : "重量", measure: "件", unit: o, c_unit: r[o], dp: E, DP: Ze[E] }, [li.MACHINE_PART.V]: { label: c ? "单重" : "重量", measure: "件", unit: o, c_unit: r[o], dp: E, DP: Ze[E] }, [li.ASSEMBLE.V]: { label: c ? "单重" : "重量", measure: "件", unit: o, c_unit: r[o], dp: E, DP: Ze[E] }, [li.ENCLOSURE.V]: { label: c ? "单长" : "长度", measure: "张", unit: n, c_unit: r[n], dp: y, DP: Ze[y] } }[e];
}
function an({ productType: e, showUnit: o = false, weight: n = { num: 0, from: "kg", to: "kg", dp: "COM_WT__KG" }, length: c = { num: 0, from: "mm", to: "mm", dp: "COM_L__MM" } }) {
  return { [li.ARTIFACT.V]: Qd, [li.MACHINE_PART.V]: Qd, [li.ASSEMBLE.V]: Qd, [li.ENCLOSURE.V]: W5e }[e]({ weight: n, length: c, showUnit: o });
}
function Qd({ weight: e, showUnit: o }) {
  const { num: n, from: c = "kg", to: u = "kg", dp: r = "COM_WT__KG" } = e;
  return St(n, c, u, Ze[r] || 2, { showUnit: o });
}
function W5e({ length: e, showUnit: o }) {
  const { num: n, from: c = "mm", to: u = "mm", dp: r = "COM_L__MM" } = e;
  return St(n, c, u, Ze[r] || 2, { showUnit: o });
}
function h6({ wageQuotaType: e }) {
  const o = e && Ca.V[e].C_UNIT, n = e && Ca.V[e].unit, c = e && Ca.V[e].meteUnit, u = e && Ca.V[e].F, r = e && Ca.V[e].DP;
  return { UNIT: o, dp: r, unit: n, meteUnit: c, field: u, precision: Ze[r] };
}
function j5e({ W_CUR_UNIT: e = "kg", weight: o, L_CUR_UNIT: n = "mm", length: c, A_CUR_UNIT: u = "mm2", surfaceArea: r, quantity: E, showUnit: y = false, wageQuotaType: b }) {
  const { UNIT: V, precision: M } = h6({ wageQuotaType: b });
  return { convertMete: { [Ca.WEIGHT.V]: function({ W_CUR_UNIT: h, weight: T }) {
    return St(T, h, V, M, { showUnit: y });
  }, [Ca.LENGTH.V]: function({ L_CUR_UNIT: h, length: T, L_DP: _ }) {
    return St(T, h, V, M, { showUnit: y });
  }, [Ca.AREA.V]: function({ A_CUR_UNIT: h, surfaceArea: T, A_DP: _ }) {
    return St(T, h, V, M, { showUnit: y });
  }, [Ca.QUANTITY.V]: function({ quantity: h }) {
    return y ? h + V : h;
  } }[b]({ W_CUR_UNIT: e, weight: o, L_CUR_UNIT: n, length: c, A_CUR_UNIT: u, surfaceArea: r, quantity: E }) };
}
function F5e({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => {
    r.processSequence = r.processSummaryDetailsDOList.map((y) => `【${y.name}│${y.completeQuantity === r.taskQuantity ? "√" : y.completeQuantity || 0}】`).join("→");
    const E = zs({ productType: r.productType, l_unit: "mm", w_unit: "kg", isSingle: true }) || {};
    return r.mete = an({ productType: r.productType, weight: { num: r.netWeight }, length: { num: r.length, to: E.unit, dp: E.dp } }), r.mete && (r.mete += E.unit), r;
  });
  return { header: e, table: u, qrCode: c, footer: n };
}
function z5e({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.processSequence = r.processSummaryList.map((E) => `【${E.name}│${E.inspectionQuantity || 0}】`).join(" "), r));
  return { header: e, table: u, qrCode: c, footer: n };
}
function B5e({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.category === 2 || r.category === 32 ? r.wide = r.unfoldedWidth : r.wide = r.width, r));
  return console.log(u), { header: e, table: u, qrCode: c, footer: n };
}
function H5e({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = [];
  for (let r = 0; r < o.length; r++) {
    const E = o[r], y = E.assembleList.length;
    for (let b = 0; b < E.assembleList.length; b++) {
      const V = E.assembleList[b];
      u.push({ ...E, rowspan: b > 0 ? 0 : y, assembleSerialNumber: V.serialNumber, assembleWeight: V.weight, assembleQuantity: V.quantity });
    }
  }
  return { header: e, table: u, qrCode: c, footer: n };
}
function q5e({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => {
    r.unCompleteQuantity = r.taskQuantity - r.completeQuantity;
    const E = zs({ productType: r.productType, w_unit: "kg" });
    return r.mete = an({ productType: r.productType, weight: { num: r.completeNetWeight }, length: { num: r.completeLength, to: E.unit, dp: E.dp } }), r;
  });
  return { header: e, table: u, qrCode: c, footer: n };
}
function G5e({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => {
    const E = r.productType && zs({ productType: r.productType });
    return r.checkMete = r.wageQuotaType && j5e({ length: r.mate, weight: r.mate, surfaceArea: r.mate, quantity: r.mate, wageQuotaType: r.wageQuotaType, showUnit: true }).convertMete, r.productMete = r.mate + (E == null ? void 0 : E.unit), r.mete = r.productType && an({ productType: r.productType, length: { num: r.length * r.quantity, to: E.unit, dp: E.dp }, weight: { num: r.netWeight * r.quantity, to: E.unit, dp: E.dp } }), r.mete && (r.mete += E == null ? void 0 : E.unit), r;
  });
  return { header: e, table: u, qrCode: c, footer: n };
}
function Q5e({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.unProducedQuantity = r.taskQuantity - r.completeQuantity - r.inProductionQuantity, Object.prototype.hasOwnProperty.call(r, "taskNetWeight") && (r.unProducedMete = r.taskNetWeight - r.completeNetWeight - r.inProductionNetWeight), Object.prototype.hasOwnProperty.call(r, "taskLength") && (r.unProducedMete = r.taskLength - r.completeLength - r.inProductionLength), r));
  return { header: e, table: u, qrCode: c, footer: n };
}
function Z5e({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => {
    const E = zs({ productType: r.productType, w_unit: "kg" });
    return r.unCompleteQuantity = r.taskQuantity - r.completeQuantity, r.unCompleteMete = an({ productType: r.productType, weight: { num: r.taskNetWeight - r.completeNetWeight }, length: { num: r.taskLength - r.completeLength, to: E.unit, dp: E.dp } }), r.unCompleteMete && (r.unCompleteMete += E.unit), r;
  });
  return { header: e, table: u, qrCode: c, footer: n };
}
function J5e({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => {
    const E = zs({ productType: r.productType, w_unit: "kg", isSingle: true });
    return r.mete = an({ productType: r.productType, length: { num: r.length, to: E.unit, dp: E.dp }, weight: { num: r.netWeight, to: E.unit, dp: E.dp } }), r.completeMete = an({ productType: r.productType, length: { num: r.length * r.completeQuantity, to: E.unit, dp: E.dp }, weight: { num: r.netWeight * r.completeQuantity, to: E.unit, dp: E.dp } }), r.shipMete = an({ productType: r.productType, length: { num: r.length * r.sendQuantity, to: E.unit, dp: E.dp }, weight: { num: r.netWeight * r.sendQuantity, to: E.unit, dp: E.dp } }), r.sendQuantity = r.sendQuantity || 0, r;
  });
  return { header: e, table: u, qrCode: c, footer: n };
}
function X5e({ header: e, table: o = [], footer: n, qrCode: c }) {
  return e && (e.project = { name: e.projectName, serialNumber: e.serialNumber }), { header: e, table: o, qrCode: c, footer: n };
}
function $5e({ header: e, table: o = [], footer: n, qrCode: c }) {
  e && (e.project = { name: e.projectName, serialNumber: e.serialNumber });
  const u = o.map((r) => (e.weightStatus === au.NET.V ? (r.totalWeight = r.totalNetWeight, r.beginningWeight = r.beginningNetWeight, r.inboundWeight = r.inboundNetWeight, r.outboundWeight = r.outboundNetWeight, r.stockWeight = r.stockNetWeight, r.packageWeight = r.packageNetWeight) : (r.totalWeight = r.totalGrossWeight, r.beginningWeight = r.beginningGrossWeight, r.inboundWeight = r.inboundGrossWeight, r.outboundWeight = r.outboundGrossWeight, r.stockWeight = r.stockGrossWeight, r.packageWeight = r.packageGrossWeight), r));
  return { header: e, table: u, qrCode: c, footer: n };
}
function eLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => {
    const E = zs({ productType: r.productType, w_unit: "kg" });
    return r.taskMete = an({ productType: r.productType, weight: { num: r.taskNetWeight }, length: { num: r.taskLength, to: E.unit, dp: E.dp } }), r.completeMete = an({ productType: r.productType, weight: { num: r.completeNetWeight }, length: { num: r.completeLength, to: E.unit, dp: E.dp } }), r;
  });
  return { header: e, table: u, qrCode: c, footer: n };
}
function tLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => {
    const E = zs({ productType: r.productType }), y = h6({ wageQuotaType: r.wageQuotaType });
    return r.checkMete = r.mate + (y == null ? void 0 : y.meteUnit), r.completeMete = an({ productType: r.productType, weight: { num: r.completeNetWeight }, length: { num: r.completeLength, to: E.unit, dp: E.dp } }), r.completeMete && (r.completeMete += E.unit), r;
  });
  return { header: e, table: u, qrCode: c, footer: n };
}
function iLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.loss = r.loss ? r.loss * 100 : r.loss, r.volumeSolids = r.volumeSolids ? r.volumeSolids * 100 : r.volumeSolids, r.surfaceArea = St(r.surfaceArea, "mm²", "㎡", Ze.COM_AREA__M2), r));
  return { header: e, table: u, qrCode: c, footer: n };
}
function aLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.completeArea = St(r.completeArea, "mm²", "㎡", Ze.COM_AREA__M2), r));
  return { header: e, table: u, qrCode: c, footer: n };
}
function lLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.materialType, e && e.enclosurePriceType, r));
  return { header: e, table: u, qrCode: c, footer: n };
}
function oLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.materialListType, e && e.enclosurePriceType, r));
  return { header: e, table: u, qrCode: c, footer: n };
}
function nLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r = Ut({ data: r, basicClass: r.basicClass, field: ["modelMete", "outboundMete", "diff"], returnNewObj: true, toNum: true }), r.diffRate = r.diffRate * 100, r));
  return { header: e, table: u, footer: n, qrCode: c };
}
function sLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  const u = o.map((r) => (r.totalLength = r.length * r.quantity, r));
  return { header: e, table: u, footer: n, qrCode: c };
}
async function rLe({ header: e, table: o = [], footer: n, qrCode: c }) {
  await Qt(o, { multipleSpec: true }), await Ut(o, { toSmallest: false, toNum: true }, { mete: ["mete", "rejectMete", "usedMete", "meteCount"], quantity: ["quantity", "rejectQuantity", "quantityCount"], amount: ["avgUnitPrice", "unitPrice", "unitPriceExcludingVAT"] });
  const u = o.map((r) => (r.unitPrice = e.boolTaxIncluded ? Mi(r.unitPrice, Ze.YUAN) : Mi(r.unitPriceExcludingVAT, Ze.YUAN), r.amountCount = e.boolTaxIncluded ? r.amountCount : r.amountExcludingVatCount, r.boolWeighting || (r.unitPrice = "未月末加权", r.amountCount = "未月末加权"), r));
  return { header: e, table: u, footer: n, qrCode: c };
}
