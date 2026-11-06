import { be as u, bf as R, bg as A, bh as g, bi as h, a3 as S, bj as L, bk as P, i as I } from "../shared/runtime.js";
import { g as H } from "./index-90569c81.js";
import { g as C } from "./index-3b2e6e51.js";
let i;
async function U({ productType: t, labelType: r, component: o, productionLineName: c, logo: s, manufacturerPhone: d, manufacturerURL: v, manufacturerName: n, printConfig: m, qrCode: a, printMode: E = A.QUEUE.V }) {
  const b = C({ productType: t, labelType: r, component: o, productionLineName: c, logo: s, manufacturerPhone: d, manufacturerURL: v, manufacturerName: n, printConfig: m });
  let l = false;
  try {
    i = await u(), i.SET_PRINT_PAGESIZE(1, 1030, 2080, "1"), i.ADD_PRINT_HTM("7mm", "2mm", "98mm", "203mm", b), i.ADD_PRINT_BARCODE("15mm", "70mm", "36mm", "36mm", "QRCode", a), i.SET_PRINT_STYLEA(0, "QRCodeVersion", 7), i.SET_PRINT_STYLEA(0, "QRCodeErrorLevel", "M"), l = await R(E);
  } catch (T) {
    throw new Error(T);
  }
  return l;
}
async function Q({ productType: t, labelType: r, component: o, manufacturerName: c, printConfig: s, qrCode: d, printMode: v = A.QUEUE.V }) {
  const n = H({ productType: t, labelType: r, component: o, manufacturerName: c, printConfig: s });
  let m = false;
  try {
    i = await u(), i.SET_PRINT_PAGESIZE(1, 1030, 680, "1"), i.ADD_PRINT_HTM("0.5mm", "3mm", "98mm", "68mm", n), i.ADD_PRINT_BARCODE("40mm", "72mm", "28mm", "28mm", "QRCode", d), i.SET_PRINT_STYLEA(0, "QRCodeVersion", 7), i.SET_PRINT_STYLEA(0, "QRCodeErrorLevel", "M"), m = await R(v);
  } catch (a) {
    throw new Error(a);
  }
  return m;
}
async function Y({ productType: t, labelType: r, component: o, productionLineName: c, manufacturerName: s, printConfig: d, qrCode: v, printMode: n = A.QUEUE.V }) {
  const m = H({ productType: t, labelType: r, component: o, productionLineName: c, manufacturerName: s, printConfig: d });
  console.log(m);
  let a = false;
  try {
    i = await u(), r === g.COMMON.V && (i.SET_PRINT_PAGESIZE(1, 1030, 300, "1"), i.ADD_PRINT_HTM("2mm", "3mm", "100%", "100%", m), i.ADD_PRINT_BARCODE("4mm", "3mm", "25mm", "25mm", "QRCode", v)), r === g.CUSTOM.V && (i.SET_PRINT_PAGESIZE(1, 1030, 500, "1"), i.ADD_PRINT_HTM("2mm", "3mm", "100%", "100%", m), i.ADD_PRINT_BARCODE("38mm", "130mm", "25mm", "25mm", "QRCode", v)), i.SET_PRINT_STYLEA(0, "QRCodeVersion", 7), i.SET_PRINT_STYLEA(0, "QRCodeErrorLevel", "M"), a = await R(n);
  } catch (E) {
    throw new Error(E);
  }
  return a;
}
async function O({ productType: t, labelType: r, component: o, manufacturerName: c, qrCode: s, printConfig: d, printMode: v = A.QUEUE.V }) {
  const n = H({ productType: t, labelType: r, component: o, manufacturerName: c, printConfig: d });
  let m = false;
  try {
    i = await u(), i.SET_PRINT_PAGESIZE(1, 1030, 680, "1"), i.ADD_PRINT_HTM("2mm", "3mm", "98mm", "68mm", n), i.ADD_PRINT_BARCODE("32mm", "72mm", "28mm", "28mm", "QRCode", s), i.SET_PRINT_STYLEA(0, "QRCodeVersion", 7), i.SET_PRINT_STYLEA(0, "QRCodeErrorLevel", "M"), m = await R(v);
  } catch (a) {
    throw new Error(a);
  }
  return m;
}
async function x({ productType: t, labelType: r, component: o, manufacturerName: c, qrCode: s, printConfig: d, printMode: v = A.QUEUE.V }) {
  const n = C({ productType: t, labelType: r, component: o, manufacturerName: c, printConfig: d });
  let m = false;
  try {
    i = await u(), i.SET_PRINT_PAGESIZE(1, 1030, 680, "1"), i.ADD_PRINT_HTM("2mm", "3mm", "98mm", "68mm", n), i.ADD_PRINT_BARCODE("32mm", "72mm", "28mm", "28mm", "QRCode", s), i.SET_PRINT_STYLEA(0, "QRCodeVersion", 7), i.SET_PRINT_STYLEA(0, "QRCodeErrorLevel", "M"), m = await R(v);
  } catch (a) {
    throw new Error(a);
  }
  return m;
}
async function B({ packageInfo: t, qrCode: r, printMode: o = A.QUEUE.V }) {
  var T, p, $;
  const c = `<div style="text-align:center;"><span tdata='pageNO'>##</span> / <span tdata='pageCount'>##</span></div>`;
  let s = "";
  s = `<div style="font-weight: bold; font-size: 12pt;color: #333;padding-bottom: 2pt;">${t.project.shortName}</div>
    <div class="package-label">
      <div class="row border-b">
        <div class="row row-2 w-1 col border-r">
          <div class="qr-content"></div>
        </div>
        <div class="row w-3 row-1 col border-b" style="font-weight:bold;font-size: 10pt;">打包单</div>
        <div class="row w-3">
          <div style="width:33.4%;" class="row-1 col border-r">包单号</div>
          <div style="width:66%;" class="row-1 col" style="font-weight:bold">${t.serialNumber}</div>
        </div>
      </div>
`;
  const d = t.showMonomer === true, v = `
  <div class="row">
  ${d ? `<div class="row-0 col border-r" style="width:16%;">
  <div class="col-div">单体</div>
  </div>` : ""}
  <div class="row-0 col border-r" style="width:${d ? "16%" : "20%"};">
  <div class="col-div">名称</div>
  </div>
  <div class="row-0 col border-r" style="width:${d ? "16%" : "20%"};">
  <div class="col-div">编号</div>
  </div>
  <div class="row-0 w-1 col border-r">
  <div class="col-div">材质</div>
  </div>
  ${t.showWidth === true ? `
  <div class="row-0 col border-r" style="width:${d ? "12%" : "13%"};">

  <div class="col-div">数量</div>
  </div>
  <div class="row-0 col" style="width:${d ? "18%" : "20%"};">
  <div class="col-div">重量(kg)</div>
  </div>
    ` : ` <div class="row-0 col" style="width:${d ? "22%" : "33%"};">
  <div class="col-div">数量</div>
  </div>
    `}

</div>
</div>`, n = `
<div class="row">
${d ? `<div class="row-0 col border-r" style="width:16%;">
<div class="col-div">单体</div>
</div>` : ""}
<div class="row-0 col border-r" style="width:${d ? "20%" : "25%"};">
<div class="col-div">编号</div>
</div>
<div class="row-0 col border-r" style="width:${d ? "22%" : "24%"};">
<div class="col-div">板型</div>
</div>
<div class="row-0 col border-r" style="width:${d ? "12%" : "14%"};">
<div class="col-div">单长</div>
</div>
<div class="row-0 col border-r" style="width:${d ? "20%" : "23%"}">
<div class="col-div">单面积</div>
</div>
<div class="row-0 col" style="width:${d ? "10%" : "12%"}">
<div class="col-div">数量</div>
</div>
</div>
</div>
`, m = `
  <div class="row">
  ${d ? `<div class="row-0 col border-r" style="width:16%;">
  <div class="col-div">单体</div>
  </div>` : ""}
  <div class="row-0 col border-r" style="width:${d ? "22%" : "26%"};">
  <div class="col-div">名称</div>
  </div>
  <div class="row-0 col border-r" style="width:${d ? "12%" : "14%"};">
  <div class="col-div">单位</div>
  </div>
  <div class="row-0 col border-r" style="width:${d ? "30%" : "35%"};">
  <div class="col-div">规格</div>
  </div>
  <div class="row-0 col" style="width:${d ? "18%" : "23%"};">
  <div class="col-div">${t.unitValue === 1 ? "核算量" : "数量"}</div>
  </div>
</div>
</div>`;
  t.productType === h.STRUCTURE.V || t.productType === h.MACHINE_PART.V || t.productType === S.MACHINE_PART.V || t.productType === S.ASSEMBLE.V ? s += v : t.productType === h.ENCLOSURE.V ? s += n : t.productType === h.AUXILIARY_MATERIAL.V && (s += m);
  let a = '<div class="package-label" style="border-top:none;border-bottom:none;">';
  for (let _ = 0; _ < t.list.length; _++) {
    const e = t.list[_];
    if (console.log(e, "item"), t.productType === h.STRUCTURE.V || t.productType === h.MACHINE_PART.V || t.productType === S.MACHINE_PART.V || t.productType === S.ASSEMBLE.V) {
      const y = e.monomerName || ((T = e.monomer) == null ? void 0 : T.name) || t.monomerName || "";
      a += `
      <div class="row border-b">
      ${d ? `<div class="row-0 col border-r" style="width:16%;">
      <div class="col-div" style="${w(y)}">${y}</div>
      </div>` : ""}
      <div class="row-0 col border-r" style="width:${d ? "16%" : "20%"};">
      <div class="col-div" style="${w(e.name)}">${t.showName === true ? e.name : ""}</div>
      </div>
      <div class="row-0 col border-r" style="width:${d ? "16%" : "20%"};">
      <div class="col-div" style="${w(`${e.serialNumber}`)}">${e.serialNumber}</div>

      </div>
      <div class="row-0 col w-1 border-r">
      <div class="col-div">${t.showMaterial === true ? e.material : ""}</div>
      </div>
      ${t.showWidth === true ? `
      <div class="row-0 col border-r" style="width:${d ? "12%" : "13%"};">
        <div class="col-div">${e.quantity}</div>
      </div>
      <div class="row-0 col" style="width:${d ? "18%" : "20%"};">
        <div class="col-div">${t.showWidth === true ? e.totalWeight : ""}</div>
      </div>` : `<div class="row-0 col" style="width:${d ? "22%" : "33%"};">
      <div class="col-div">${e.quantity}</div>
      </div>
    `}

    </div>
    `;
    } else if (t.productType === h.ENCLOSURE.V) {
      const y = e.monomerName || ((p = e.monomer) == null ? void 0 : p.name) || t.monomerName || "";
      a += `
      <div class="row border-b">
      ${d ? `<div class="row-0 col border-r" style="width:16%;">
      <div class="col-div" style="${w(y)}">${y}</div>
      </div>` : ""}
      <div class="row-0 col border-r" style="width:${d ? "20%" : "25%"};">
      <div class="col-div" style="${w(e.serialNumber)}">${e.serialNumber}</div>

      </div>
      <div class="row-0 col border-r" style="width:${d ? "22%" : "24%"};">
      <div class="col-div">${e.plate}</div>
      </div>
      <div class="row-0 col border-r" style="width:${d ? "12%" : "14%"};">
      <div class="col-div">${e.length}</div>
      </div>
      <div class="row-0 col border-r" style="width:${d ? "20%" : "23%"}">
      <div class="col-div">${e.surfaceArea}</div>
      </div>
      <div class="row-0 col" style="width:${d ? "10%" : "12%"}">
      <div class="col-div">${e.quantity}</div>
      </div>
    </div>
    `;
    } else if (t.productType === h.AUXILIARY_MATERIAL.V) {
      const y = e.monomerName || (($ = e.monomer) == null ? void 0 : $.name) || t.monomerName || "";
      a += `
      <div class="row border-b">
      ${d ? `<div class="row-0 col border-r" style="width:16%;">
      <div class="col-div" style="${w(y)}">${y}</div>
      </div>` : ""}
      <div class="row-0 col border-r" style="width:${d ? "22%" : "26%"};">
      <div class="col-div" style="${w(e.name)}">${t.showName === true ? e.name : ""}</div>

      </div>
      <div class="row-0 col border-r" style="width:${d ? "12%" : "14%"};">
      <div class="col-div">${t.unitValue === 1 ? e.accountingUnit : e.measureUnit}</div>
      </div>
      <div class="row-0 col border-r" style="width:${d ? "30%" : "35%"};">
      <div class="col-div" style="${w(e.specification)}">${e.specification}</div>

      </div>
      <div class="row-0 col" style="width:${d ? "18%" : "23%"};">
      <div class="col-div">${t.unitValue === 1 ? e.packageMete : e.quantity}</div>
      </div>
    </div>
    `;
    }
  }
  a += "</div>";
  const E = P(D, a), b = P(D, s);
  let l = false;
  try {
    i = await u(), i.SET_PRINT_PAGESIZE(2, 1030, 680, "1"), i.ADD_PRINT_HTM("3mm", "1.5mm", "67mm", "29.5mm", b), i.SET_PRINT_STYLEA(0, "ItemType", 1), i.ADD_PRINT_HTM("31.7mm", "1.5mm", "67mm", "61.5mm", E), i.ADD_PRINT_HTM("96mm", "1.5mm", "67mm", "5mm", c), i.SET_PRINT_STYLEA(0, "ItemType", 1), i.ADD_PRINT_BARCODE("8.8mm", "1.8mm", "16.4mm", "16.4mm", "QRCode", r), i.SET_PRINT_STYLEA(0, "QRCodeVersion", 3), i.SET_PRINT_STYLEA(0, "ItemType", 1), l = await R(o);
  } catch (_) {
    throw new Error(_);
  }
  return l;
}
async function z({ packageInfo: t, qrCode: r, printMode: o = A.QUEUE.V }) {
  var E;
  console.log("printCombinedPackageLabel:", t);
  const c = `<div style="text-align:center;"><span tdata='pageNO'>##</span> / <span tdata='pageCount'>##</span></div>`, s = t.showMonomer === true;
  let d = "";
  d = `<div style="font-weight: bold; font-size: 12pt;color: #333;padding-bottom: 2pt;text-align: center;">打包单</div>
    <div class="package-label">
      <div class="row border-b">
        <div class="row row-2 w-1 col border-r">
          <div class="qr-content"></div>
        </div>
        <div class="row w-3 row-1 col border-b">
        <div style="width:33.4%;" class="row-1 col border-r">项目</div>
          <div style="width:66%;" class="row-1 col" style="font-weight:bold">${t.project.shortName}</div>
        </div>
        <div class="row w-3">
          <div style="width:33.4%;" class="row-1 col border-r">包单号</div>
          <div style="width:66%;" class="row-1 col" style="font-weight:bold">${t.serialNumber}</div>
        </div>
      </div>
`, t.labelType === L.ONE.V ? d += `
    <div class="row">
      ${s ? `<div class="row-0 col border-r" style="width:18%;">
        <div class="col-div">单体</div>
      </div>` : ""}
      <div class="row-0 w-1 col border-r">
        <div class="col-div">类型</div>
      </div>
      <div class="row-0 col border-r" style="width:${s ? "22%" : "34%"};">
        <div class="col-div">${t.productType === h.AUXILIARY_MATERIAL.V ? "名称" : "编号"}</div>
      </div>
      <div class="row-0 col border-r" style="width:${s ? "16%" : "19.5%"};">
        <div class="col-div">单位</div>
      </div>
      <div class="row-0 col" style="width:${s ? "16%" : "20%"};">
        <div class="col-div">数量</div>
      </div>
    </div>` : t.labelType === L.TWO.V && (d += `
    <div class="row">
      ${s ? `<div class="row-0 w-1 col border-r" style="width:16%;">
        <div class="col-div">单体</div>
      </div>` : ""}
      <div class="row-0 w-1 col border-r" style="width:${s ? "16%" : "20%"};">
        <div class="col-div">名称</div>
      </div>
      <div class="row-0 w-1 col border-r" style="width:${s ? "16%" : "20%"};">
        <div class="col-div">编号</div>
      </div>
      <div class="row-0 col border-r" style="width:${s ? "22%" : "25%"};">
        <div class="col-div">规格</div>
      </div>
      <div class="row-0 w-1 col border-r" style="width:${s ? "12%" : "13%"};">
        <div class="col-div">数量</div>
      </div>
      <div class="row-0 w-1 col" style="width:${s ? "16%" : "20.5%"};">
        <div class="col-div">核算量</div>
      </div>
    </div>`);
  let v = '<div class="package-label" style="border-top:none;border-bottom:none;">';
  for (let b = 0; b < t.list.length; b++) {
    const l = t.list[b], T = l.monomerName || ((E = l.monomer) == null ? void 0 : E.name) || t.monomerName || "";
    t.labelType === L.ONE.V ? v += `
      <div class="row border-b">
        ${s ? `<div class="row-0 col border-r" style="width:18%;">
          <div class="col-div" style="${w(T)}">${T}</div>
        </div>` : ""}
        <div class="row-0 col w-1 border-r">
          <div class="col-div">${l.productType ? h.V[l.productType].SL : ""}</div>
        </div>
        <div class="row-0 col border-r" style="width:${s ? "22%" : "34%"};">
          <div class="col-div" style="${w(`${l.productType === h.AUXILIARY_MATERIAL.V ? l.name : l.serialNumber}`)}">

          ${l.productType === h.AUXILIARY_MATERIAL.V ? l.name : l.serialNumber}
          </div>
        </div>
        <div class="row-0 col border-r" style="width:${s ? "16%" : "19.5%"};">
          <div class="col-div">${l.measureUnit}</div>
        </div>
        <div class="row-0 col" style="width:${s ? "16%" : "20%"};">
          <div class="col-div">${l.packageQuantity}</div>
        </div>
      </div>
    ` : t.labelType === L.TWO.V && (v += `
      <div class="row border-b">
        ${s ? `<div class="row-0 col w-1 border-r" style="width:16%;">
          <div class="col-div" style="${w(T)}">${T}</div>
        </div>` : ""}
        <div class="row-0 col w-1 border-r" style="width:${s ? "16%" : "20%"};">
          <div class="col-div" style="${w(l.name)}">${l.name}</div>
        </div>
        <div class="row-0 col w-1 border-r" style="width:${s ? "16%" : "20%"};">
          <div class="col-div" style="${w(`${l.serialNumber}`)}">${l.serialNumber}</div>
        </div>
        <div class="row-0 col w-1 border-r" style="width:${s ? "22%" : "25%"};">
          <div class="col-div" style="${w(l.specification)}">${l.specification}</div>
        </div>
        <div class="row-0 col w-1 border-r" style="width:${s ? "12%" : "13%"};">
          <div class="col-div" style="font-size:7pt;">${l.packageQuantity}</div>
        </div>
        <div class="row-0 col w-1" style="width:${s ? "16%" : "20.5%"};">
          <div class="col-div" style="font-size:7pt;">${l.mete} ${l.accountingUnit}</div>
        </div>
      </div>
    `);
  }
  v += "</div>";
  const n = P(D, v), m = P(D, d);
  let a = false;
  try {
    i = await u(), i.SET_PRINT_PAGESIZE(1, 1030, 680, "1"), i.ADD_PRINT_HTM("3mm", "1.5mm", "99.3mm", "29.6mm", m), i.SET_PRINT_STYLEA(0, "ItemType", 1), i.ADD_PRINT_HTM("31.5mm", "1.5mm", "99.3mm", "30.56mm", n), i.ADD_PRINT_HTM("63mm", "1.5mm", "99.3mm", "3mm", c), i.SET_PRINT_STYLEA(0, "ItemType", 1), i.ADD_PRINT_BARCODE("8.8mm", "6.8mm", "16.4mm", "16.4mm", "QRCode", r), i.SET_PRINT_STYLEA(0, "QRCodeVersion", 3), i.SET_PRINT_STYLEA(0, "ItemType", 1), a = await R(o);
  } catch (b) {
    throw new Error(b);
  }
  return a;
}
function w(t = "") {
  const r = t.length;
  let o = "5pt", c = "20%";
  return r <= 5 && (o = "9pt", c = "50%"), r > 5 && r <= 10 && (o = "7pt", c = "50%"), r > 10 && r <= 15 && (o = "7pt", c = "25%"), r > 15 && r <= 20 && (o = "5pt", c = "25%"), `font-size:${o};top:${c}`;
}
async function G({ taskNumberOrder: t = "", separateOrderInfo: r, printMode: o = A.QUEUE.V } = {}) {
  var T;
  const c = "5mm", s = `<div style="text-align:center;"><span tdata='pageNO'>##</span> / <span tdata='pageCount'>##</span></div>`, d = `
  <div style="font-size: 17pt; font-weight: bold; height: 10mm; text-align:center;">零件分拣单</div>
  <div style="font-size: 12pt; padding:0 ${c};margin-top: 3mm;margin-bottom: 1mm;">任务单：${t}</div>
  `;
  let v = "";
  const n = "25mm", m = "20mm";
  for (let p = 0; p < r.length; p++) {
    const $ = r[p];
    let _ = "", e = "";
    for (let y = 0; y < ((T = $.productionLineList) == null ? void 0 : T.length); y++) {
      const N = $.productionLineList[y];
      _ += `
      <td>
        ${I(N) ? `<span>${N.productionLineName}>${N.groupName}</span>` : "<span>\\</span>"}
      </td>
      `, e += `
      <td>
        ${I(N) ? `<span>${N.quantity}</span>` : "<span>\\</span>"}
      </td>
      `;
    }
    v += `
        <tr class="separate-thead">
          <td style="width: ${n}">${$.serialNumber}</td>
          ${_}
        </tr>
        <tr>
          <td class="separate-td-img">
            ${$.picturePath ? `<img style="width: 95%;height: 95%;vertical-align: middle;" src='${$.picturePath}' />` : "<span>\\</span>"}
          </td>
          ${e}
        </tr>
     
    `;
  }
  const a = `<table class="separate-table" cellspacing="0" cellpadding="0" border="1">
        <tbody>
          ${v}  
        </tbody>
      </table>`, E = `
  <style>
    .separate-table {
      width: 100%;
      table-layout: fixed;
      border-collapse: collapse;  
    }
    .separate-table td {
      text-align: center;
    }
    .separate-table .separate-thead {
      background-color: #d9d9d9;
    }
    .separate-table .separate-thead td {
      font-size: 10pt;
    }
    .separate-table .separate-td-img {
      height: ${m};
      text-align: center;
    }
  </style>`, b = P(E, a);
  let l = false;
  try {
    i = await u(), i.SET_PRINT_PAGESIZE(3, 0, 0, "A4"), i.ADD_PRINT_HTM("5mm", "0mm", "100%", "25mm", d), i.SET_PRINT_STYLEA(0, "ItemType", 1), i.ADD_PRINT_TABLE("25mm", "5mm", "200mm", "255mm", b), i.ADD_PRINT_HTM(`${25 + 255 + 5}mm`, "0", "100%", "5mm", s), i.SET_PRINT_STYLEA(0, "ItemType", 1), l = await R(o);
  } catch (p) {
    throw new Error(p);
  }
  return l;
}
const D = `
  <style>
  .package-label {
    float: left;
    font-family: "微软雅黑";
    font-size: 9pt;
    color: black;
    width: 100%;
    border: 1px solid #000;
  }

  .row {
    width: 100%;
    float: left;
  }

  .w-1 {
    width: 25%;
  }

  .w-2 {
    width: 50%;
  }

  .w-3 {
    width: 74.5%;
  }

  .row-0 {
    /**height: 5.85mm;**/
    height: 5.823mm;
    position: relative;
  }

  .col-div {
    width: 100%;
    text-align: center;
    position: absolute;
    left: 0;
    top: 50%;
    margin: -0.5em 0 0 0;
  }

  .row-1 {
    height: 7.9mm;
    line-height: 7mm;
  }

  .row-2 {
    height: 16mm;
    line-height: 16mm;
  }

  .border-r {
    border-right: 1px solid #000;
  }

  .border-t {
    border-top: 1px solid #000;
  }

  .border-b {
    border-bottom: 1px solid #000;
  }

  .col {
    float: left;
    word-break: break-all;
    text-align: center;
  }
</style>`;
export {
  U as a,
  B as b,
  G as c,
  Y as d,
  Q as e,
  O as f,
  z as g,
  x as p
};
