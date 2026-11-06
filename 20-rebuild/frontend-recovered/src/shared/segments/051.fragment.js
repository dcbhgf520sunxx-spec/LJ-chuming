for (const e in Pb) Object.assign(vn, { ...Pb[e].default });
const Ob = Ra.key2val(ke), qs = 2, FR = (e) => {
  const o = [];
  return e.forEach((n) => {
    o.push(n), n.children && o.push.apply(o, FR(n.children));
  }), o;
}, i2 = (e) => {
  const o = (n) => {
    let c = 0;
    for (; c < n.length; ) {
      const u = n[c];
      if (!u.show) {
        n.splice(c, 1);
        continue;
      }
      if (u.children && (o(u.children), u.children.length === 0)) {
        n.splice(c, 1);
        continue;
      }
      c++;
    }
  };
  return o(e), e;
}, a2 = (e) => {
  let o = 1;
  const n = (r, E) => {
    if (E && (r.level = E.level + 1, o < r.level && (o = r.level)), r.children) {
      let y = 0;
      r.children.forEach((b) => {
        n(b, r), y += b.colSpan;
      }), r.colSpan = y;
    } else r.colSpan = 1;
  };
  e.forEach((r) => {
    r.level = 1, n(r);
  });
  const c = [];
  for (let r = 0; r < o; r++) c.push([]);
  return FR(e).forEach((r) => {
    r.children ? r.rowSpan = 1 : r.rowSpan = o - r.level + 1, c[r.level - 1].push(r);
  }), c;
}, l2 = (e) => {
  const o = [], n = e.length;
  return e.forEach((c) => {
    c.forEach((u) => {
      (u.level === n || u.rowSpan > 1) && o.push(u);
    });
  }), o;
}, Aft = { correctJSON(e) {
  return e || (e = {}), e.fontUnit || (e.fontUnit = "pt"), e.logo || (e.logo = { show: false }), e.title || (e.title = { show: true }), e.header || (e.header = { show: true }), e.header.fields || (e.header.fields = []), e.footer || (e.footer = { show: true }), e.footer.fields || (e.footer.fields = []), e.footer.tip || (e.footer.tip = {}), e.page || (e.page = { show: true }), e.table || (e.table = { show: true }), e.table.th || (e.table.th = {}), e.table.td || (e.table.td = {}), e.table.index || (e.table.index = {}), e.table.summary || (e.table.summary = {}), e.table.fields || (e.table.fields = []), e;
}, getTitleHtml(e) {
  return A(e) ? `<span>${e.title || ""}</span>` : "";
}, getPageHtml(e) {
  return A(e) ? `<span>${this.pageFormat(e.format)}</span>` : "";
}, getHeaderHtml(e, o) {
  if (!o) return "";
  let n = "";
  if (o.fields) {
    for (const c of o.fields) if (c.show) {
      if (n += `<div style="${c.style}">`, c.title && (n += `<span style="font-weight:${o.bold}">${c.title}</span>`), e && c.key) {
        const u = this.dataFormat({ row: e, field: c, emptyVal: o.emptyVal });
        n += A(u) ? `<span>${u}</span>` : "";
      }
      n += "</div>";
    }
  }
  return n;
}, getFooterHtml(e, o) {
  const n = o.footer;
  if (!n) return "";
  const c = n.tip;
  let u = "";
  if (c && c.show && c.above && (u += `<span class="tip" style="font-size:${c.size}${o.fontUnit};font-weight:${c.bold};text-align:${this.textAlign(c.align)}">${A(c.text) ? c.text : ""}</span>`), n.fields) {
    for (const r of n.fields) if (r.show) {
      if (u += `<div style="${r.style}">`, r.title && (u += `<span style="font-weight:${n.bold}">${r.title}</span>`), e && r.key) {
        const E = this.dataFormat({ row: e, field: r, emptyVal: n.emptyVal });
        u += A(E) ? `<span>${E}</span>` : "";
      }
      u += "</div>";
    }
  }
  return c && c.show && !c.above && (u += `<span class="tip" style="font-size:${c.size}${o.fontUnit};font-weight:${c.bold};text-align:${this.textAlign(c.align)}">${A(c.text) ? c.text : ""}</span>`), u;
}, getTHeadHtml(e, o, n) {
  const c = o.columnRows;
  let u = "<thead>";
  return c.forEach((r, E) => {
    if (u += "<tr>", E === 0 && e.index && e.index.show) {
      const y = e.index.style;
      u += `<th rowspan="${c.length}" style="${y}"><div style="${y}">${e.index.title || "序号"}</div></th>`;
    }
    r.forEach((y) => {
      y.show && (u += `<th colspan="${y.colSpan}" rowspan="${y.rowSpan}" style="${y.style}"><div style="${y.style}">${y.title || ""}</div></th>`);
    }), E === 0 && n && (u += '<th scope="col" class="blank-column"><div></div></th>'), u += "</tr>";
  }), u += "</thead>", u;
}, getTableHtml(e, o, n) {
  if (!o) return "";
  let c = "";
  const u = o.index && o.index.show && A(o.index.width) && n.lastColumns.every((E) => A(E.width));
  c += `
      <table class="preview-table" border="1">
       ${this.getTHeadHtml(o, n, u)}
        <tbody>
        `;
  let r = 0;
  for (const E of e) {
    if (c += "<tr>", o.index && o.index.show) {
      const y = o.index.style;
      c += `<td style="${y}"><div style="${y}">${r + 1}</div></td>`;
    }
    for (const y of n.lastColumns) {
      const b = this.dataFormat({ row: E, field: y, emptyVal: o.emptyVal });
      if (y.type === a.IMAGE.K) {
        const V = `width: 100%;display:flex;justify-content:${this.flexAlign(y.align)};align-items:center;`;
        c += `<td style="${y.style}"><div style="${V}">${b}</div></td>`;
      } else c += `<td style="${y.style}"><div style="${y.style}">${b}</div></td>`;
    }
    u && (c += '<td class="blank-column"><div></div></td>'), c += "</tr>", ++r;
  }
  return o.summary && o.summary.show && (c += this.spliceSummary({ data: e, config: o, needBlankColumn: u, columnCfg: n })), c += `
        </tbody>
      </table>
      `, c;
}, spliceSummary({ data: e, config: o, needBlankColumn: n, columnCfg: c }) {
  let u = "<tr>";
  if (o.index && o.index.show) {
    const r = o.index.style;
    u += `<td style="${r}"><div style="${r}">${o.summary.title || "合计"}</div></td>`;
  }
  for (const r of c.lastColumns) {
    let E = "";
    if (r && r.sum) {
      const y = e.map((M) => this.keyParse(M, r.key));
      let b = 0;
      const V = [];
      if (!y.every((M) => isNaN(+M))) {
        E = y.reduce((g, S) => {
          const h = Number(S);
          return isNaN(h) ? g : (V.push(Ho(S)), g + Number(S));
        }, 0), b = V.getMax(), b = b > 5 ? 5 : b;
        const M = JSON.parse(JSON.stringify(r));
        M.format || (M.format = {}), Ae(M.format.precision) && (M.format.precision = b), E = this.dataFormat({ val: E, field: M });
      }
    }
    u += `<td style="${r.style}"><div style="${r.style}">${E}</div></td>`;
  }
  return n && (u += '<td class="blank-column"><div></div></td>'), u += "</tr>", u;
}, setTableStyle(e, o) {
  const n = e.table;
  if (e && A(n)) {
    this.setTableColumnsStyle(e, o);
    let c = "<style>";
    A(n.th) && (c += `
      .preview-table th {`, A(n.th.size) && (c += ` font-size: ${n.th.size}${e.fontUnit};`), A(n.th.bold) && (c += ` font-weight: ${n.th.bold};`), A(n.th.lineHeight) && (c += ` line-height: ${n.th.lineHeight}${e.fontUnit}!important;`), c += "}", c += `
      .preview-table th >div{`, A(n.th.paddingTB) && (c += ` padding-top: ${n.th.paddingTB}${e.unit}!important;`, c += ` padding-bottom: ${n.th.paddingTB}${e.unit}!important;`), c += "}"), A(n.td) && (c += `
      .preview-table td {`, A(n.td.size) && (c += ` font-size: ${n.td.size}${e.fontUnit};`), A(n.td.bold) && (c += ` font-weight: ${n.td.bold};`), A(n.td.lineHeight) && (c += ` line-height: ${n.td.lineHeight}${e.fontUnit}!important;`), c += "}", c += `
      .preview-table td >div{`, A(n.td.paddingTB) && (c += ` padding-top: ${n.td.paddingTB}${e.unit}!important;`, c += ` padding-bottom: ${n.td.paddingTB}${e.unit}!important;`), c += "}"), c += "</style>", n.style = c;
  }
}, setTableColumnsStyle(e, o) {
  const n = e.table;
  if (e && A(n)) {
    o.columnRows.forEach((r) => {
      r.forEach((E) => {
        let y = "";
        A(E.align) && (y += `text-align:${this.textAlign(E.align)};`), A(E.width) ? y += `width:${E.width}${e.unit};` : A(E.minWidth) && (y += `min-width:${E.minWidth}${e.unit};`), E.style = y;
      });
    });
    const u = n.index;
    if (A(n.index)) {
      let r = "";
      A(u.align) && (r += `text-align:${this.textAlign(u.align)};`), A(u.width) ? r += `width:${u.width}${e.unit};` : A(u.minWidth) && (r += `min-width:${u.minWidth}${e.unit};`), u.style = r;
    }
  }
}, setHeaderFieldStyle(e) {
  const o = e.header;
  if (e && A(o)) {
    const n = o.fields;
    A(n) && n.forEach((c) => {
      let u = "";
      A(c.width) ? u += `width:${c.width}${e.unit};` : A(c.maxWidth) && (u += `max-width:${c.maxWidth}${e.unit};`), c.style = u;
    });
  }
}, setFooterFieldStyle(e) {
  const o = e.footer;
  if (e && A(o)) {
    const n = o.fields;
    A(n) && n.forEach((c) => {
      let u = "";
      A(c.width) ? u += `width:${c.width}${e.unit};` : A(c.maxWidth) && (u += `max-width:${c.maxWidth}${e.unit};`), A(c.align) && (u += `text-align:${this.textAlign(c.align)};`), c.style = u;
    });
  }
}, dataFormat({ row: e = {}, val: o, field: n, emptyVal: c = "" }) {
  switch (n.source === i.CUSTOMIZE.V && (c = ""), !A(o) && A(e) && A(n) && (o = this.keyParse(e, n.key)), n.type) {
    case a.PROJECT.K:
      return Si(this.projectNameFormat(o, n.format), c);
    case a.DATE.K:
      return Si(this.dateFormat(o, n.format), c);
    case a.DATES.K:
      return Si(this.dateFormat(o, n.format), c);
    case a.AMOUNT.K:
      return Si(this.amountFormat(o, n.format), c);
    case a.WEIGHT.K:
      return Si(this.weightFormat(o, n.format), c);
    case a.LENGTH.K:
      return Si(this.lengthFormat(o, n.format), c);
    case a.RATE.K:
      return Si(this.rateFormat(o, n.format), c);
    case a.THICKNESS.K:
      return Si(this.thicknessFormat(o, n.format), c);
    case a.METE.K:
      return Si(this.meteFormat({ val: o, row: e, format: n.format }), c);
    case a.QUANTITY.K:
      return Si(this.quantityFormat(o, n.format), c);
    case a.ENUM.K:
      return Si(this.enumFormat(o, n.format), c);
    case a.IMAGE.K:
      return ` <img style="width:95%;" src="${o || ""}"/>`;
    default:
      return Si(o, c);
  }
}, keyParse(e, o) {
  if (A(e) && A(o) && typeof o == "string") {
    const c = o.split(".");
    return c.length === 1 ? e[c[0]] : c.reduce((u, r) => en.isPlainObject(u) ? u[r] : void 0, e);
  }
}, enumFormat(e, o) {
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
}, projectNameFormat(e, o = {}) {
  return A(o) || (o = { showProjectFullName: false, showSerialNumber: false, projectNameShowConfig: nt.SERIAL_NUMBER_START.V }), di(e, o, o.lineBreak);
}, dateFormat(e, o = "YY/MM/DD") {
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
}, amountFormat(e, o = {}) {
  let n = e;
  return A(n) && (A(o.unit) && o.unit === We.WAN.V && (n /= 1e4), A(o.precision) && (n = (+n).toFixed(o.precision)), o.toThousand && (n = Mi(n, o.precision ?? qs))), n;
}, weightFormat(e, o = {}) {
  let n = e;
  return A(n) && (A(o.unit) && (n = St(n, rt.WEIGHT, o.unit)), A(o.precision) && (n = (+n).toFixed(o.precision)), o.toThousand && (n = Mi(n, o.precision ?? qs))), n;
}, lengthFormat(e, o = {}) {
  let n = e;
  return A(n) && (A(o.unit) && (n = St(n, rt.LENGTH, o.unit)), A(o.precision) && (n = (+n).toFixed(o.precision)), o.toThousand && (n = Mi(n, o.precision ?? qs))), n;
}, thicknessFormat(e, o = {}) {
  let n = e;
  return A(n) && (A(o.unit) && (n = St(n, Ft.THICKNESS, o.unit)), A(o.precision) && (n = (+n).toFixed(o.precision)), o.toThousand && (n = Mi(n, o.precision ?? qs))), n;
}, meteFormat({ val: e, row: o, format: n = {} }) {
  let c = e;
  return A(c) && (A(n.precision) && (c = (+c).toFixed(n.precision)), n.toThousand && (c = Mi(c, n.precision ?? qs)), n.showUnit && (n.unit && (c += ` ${n.unit}`), o != null && o[n.rowUnit] && (c += ` ${o[n.rowUnit]}`))), c;
}, quantityFormat(e, o = {}) {
  let n = e;
  return A(n) && (A(o.precision) && (n = (+n).toFixed(o.precision)), o.toThousand && (n = Mi(n, o.precision ?? qs))), n;
}, rateFormat(e, o = {}) {
  let n = e;
  return A(o.precision) && (n = (+n).toFixed(o.precision)), n + "%";
}, flexAlign(e) {
  switch (e) {
    case t.LEFT.V:
      return "flex-start";
    case t.RIGHT.V:
      return "flex-end";
    case t.CENTER.V:
      return "center";
    default:
      return "flex-start";
  }
}, verticleAlign(e) {
  switch (e) {
    case D.TOP.V:
      return "flex-start";
    case D.BOTTOM.V:
      return "flex-end";
    case D.CENTER.V:
      return "center";
    default:
      return "flex-start";
  }
}, textAlign(e) {
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
}, pageFormat(e) {
  return Ob[e] ? Ob[e].L : "1 / 1";
} }, Em = 8.1, Rr = 2, ku = { style: "thin", color: "e10602FF" }, zR = { left: ku, right: ku, top: ku, bottom: ku };
async function QZ({ filename: e, title: o, header: n = {}, table: c = [], footer: u = {}, qrCode: r, config: E }) {
  if (!A(E)) throw new Error("未配置");
  if (console.log(E, "config111111"), A(E.logo) && E.logo.show && E.logo.url) {
    const x = await WR(E.logo.url);
    x && (E.logo.binary = jR(x));
  }
  const y = E.title, b = E.header, V = E.table, M = E.footer, g = E.logo, S = E.qrCode;
  o && (y.title = o);
  const h = { height: E.height, width: E.width, paddingTB: E.paddingTB, paddingLR: E.paddingLR, aclHeight: E.height - E.paddingTB * 2, aclWidth: E.width - E.paddingLR * 2, unit: E.unit }, T = { title: void 0, header: void 0, tHeader: void 0, tBody: void 0, footer: void 0, footerTip: void 0, footerExtra: void 0, all: void 0 }, _ = { title: 0, header: 0, tHeader: 0, tBody: 0, footer: 0, footerTip: 0, footerExtra: 0 }, f = [], m = [], R = (e || E.name) + ".xlsx", v = Yi.utils.book_new();
  var N = { WTF: true, cellStyles: true, dateNF: "yyyy/mm/dd" };
  const P = [], L = y.title;
  var O = Yi.utils.aoa_to_sheet(P, N);
  return O["!rows"] = [], O["!cols"] = [], $Z({ config: E, baseCfg: h, ws: O }), ZZ(V), T.header = tJ({ config: y, baseCfg: h, ws: O, sr: T, rn: _ }), T.tHeader = iJ({ data: n, config: b, baseCfg: h, ws: O, sr: T, rn: _, headerRows: f }), T.footer = lJ({ data: c, config: V, baseCfg: h, ws: O, sr: T, rn: _ }), T.all = oJ({ data: u, config: M, baseCfg: h, ws: O, sr: T, rn: _, footerRows: m }), eJ({ ws: O, headerCfg: b, tableCfg: V, footerCfg: M, baseCfg: h, sr: T, rn: _, headerRows: f, footerRows: m }), JZ({ baseCfg: h, config: g, ws: O }), A(S) && S.show && XZ({ baseCfg: h, qrCode: r, config: S, ws: O }), Yi.utils.book_append_sheet(v, O, L), Yi.write(v, { file: R, bookType: "xlsx", bookSST: false, type: "file", cellStyles: false }), true;
}
function ZZ(e) {
  e && (e.columns = i2(JSON.parse(JSON.stringify(e.fields))), e.columnRows = a2(e.columns), e.lastColumns = l2(e.columnRows));
}
function JZ({ baseCfg: e, config: o, ws: n }) {
  !o || !o.binary || BR(n, e, { name: `LOGO_${Tt()}.${h_(o.url) || "png"}`, data: o.binary, width: o.width, height: o.height, top: o.top, left: o.left });
}
function XZ({ baseCfg: e, qrCode: o, config: n, ws: c }) {
  if (!n || !o) return;
  const u = WV.getQrBase64(o, { padding: 0, correctLevel: 1, width: ta(n.width, e.unit), height: ta(n.height, e.unit) });
  BR(c, e, { name: Tt() + ".png", data: t2(u), width: n.width, height: n.height, top: n.top, left: n.left });
}
function BR(e, o, { name: n, data: c, type: u, width: r, height: E, top: y, left: b }) {
  e["!drawing"] || (e["!drawing"] = []);
  const V = ta(r, o.unit), M = ta(E, o.unit);
  let g = ta(y - o.paddingTB, o.unit), S = ta(b - o.paddingLR, o.unit);
  const h = ta(o.aclWidth, o.unit) - V - b, T = ta(o.aclHeight, o.unit) - M - y;
  h < 0 && (S += h), T < 0 && (g += T), g < 0 && (g = 0), S < 0 && (S = 0);
  let _ = S + V;
  const f = g + M, m = e["!cols"].map((I) => I.wpx), R = m.reduce((I, Y) => I + Y, 0), v = e["!rows"].map((I) => (I.hpx || ul(I.hpt)) * 1.33), N = _ - R;
  N > 0 && (S -= N, S < 0 && (S = 0), _ = S + V);
  const P = { col: void 0, row: void 0, colOff: void 0, rowOff: void 0 }, L = { col: void 0, row: void 0, colOff: void 0, rowOff: void 0 };
  let O = 0;
  for (let I = 0; I < m.length; I++) if (O += m[I], !A(P.col) && O >= S && (P.col = I, P.colOff = To(S - (O - m[I]))), O >= _) {
    L.col = I, L.colOff = To(_ - (O - m[I]));
    break;
  }
  if (L.colOff === void 0) {
    const I = m.length - 1;
    L.col = I, L.colOff = To(m[I]);
  }
  let x = 0;
  for (let I = 0; I < v.length; I++) if (x += v[I], !A(P.row) && x >= g && (P.row = I, P.rowOff = To(g - (x - v[I]))), x >= f) {
    L.row = I, L.rowOff = To(f - (x - v[I]));
    break;
  }
  if (L.rowOff === void 0) {
    const I = f - x;
    e["!rows"].push({ hpx: I }), L.row = v.length, L.rowOff = To(I);
  }
  e["!drawing"].push({ name: n, data: c, opts: { base64: false, binary: true, optimizedBinaryString: false }, type: u, attrs: { editAs: "oneCell" }, spPr: { xfrm: { off: { x: 0, y: 0 }, ext: { cx: 0, cy: 0 } } }, position: { type: "twoCellAnchor", from: P, to: L } });
}
function $Z({ baseCfg: e, ws: o }) {
  o["!margins"] = { left: St(e.paddingLR, e.unit, "in"), right: St(e.paddingLR, e.unit, "in"), top: St(e.paddingTB, e.unit, "in"), bottom: St(e.paddingTB, e.unit, "in"), header: 0, footer: 0.393 };
}
function eJ({ ws: e, headerCfg: o, tableCfg: n, footerCfg: c, baseCfg: u, sr: r, rn: E, headerRows: y, footerRows: b }) {
  if (!e["!ref"]) return;
  const V = e["!ref"].split(":"), M = Yi.utils.decode_cell(V[0]), g = Yi.utils.decode_cell(V.length > 1 ? V[1] : V[0]), S = [];
  if (!E.tHeader && !E.tBody) if (g.c === 0) e["!rows"].push({ hpx: ta(u.aclHeight, u.unit) });
  else {
    const T = y.map((Y) => Y.length), _ = b.map((Y) => Y.length), f = T.maxIndex(), m = _.maxIndex(), R = T[f], v = _[m];
    let N, P, L;
    R >= v ? (N = en.sum(T.slice(0, f)), P = N + R - 1, L = o.fields ? o.fields.filter((Y) => Y.show) : []) : (N = en.sum(_.slice(0, m)), P = N + v - 1, L = c.fields ? c.fields.filter((Y) => Y.show) : []);
    const O = JSON.parse(JSON.stringify(L.slice(N, P + 1))), x = en.sum(O.map((Y) => (Y.realWidth = A(Y.width) ? Y.width : Y.maxWidth, Y.realWidth)));
    O.map((Y) => Math.floor(Y.realWidth / x * 100) / 100).forEach((Y) => {
      const ee = Math.floor(Y * u.aclWidth * 100) / 100;
      e["!cols"].push({ wpx: ta(ee, u.unit), MDW: Em });
    });
  }
  const h = e["!cols"].map((T) => T.wpx);
  if (E.title && S.push({ s: { r: M.r, c: M.c }, e: { r: M.r, c: g.c } }), E.footerTip && S.push({ s: { r: r.footerTip, c: M.c }, e: { r: r.footerTip, c: g.c } }), E.header) {
    const T = o.fields ? o.fields.filter((R) => R.show) : [], _ = [], f = r.header, m = f + E.header;
    for (let R = f; R < m; R++) {
      const v = y[R - f], P = T.splice(0, v.length).map((Y) => {
        const ee = A(Y.width) ? Y.width : Y.maxWidth;
        return ta(ee, u.unit);
      }), L = [...h], O = P.map((Y, ee) => {
        let B = true, q = 0, ae = 0;
        for (; B && L.length > 0; ) if (q += L[0], q >= Y && ae !== 0) {
          const j = Math.abs(q - Y), le = Math.abs(q - L[0] - Y);
          j < le && (L.shift(), ae += 1), B = false;
        } else L.shift(), ae += 1;
        return ae;
      });
      for (let Y = 0; Y < O.length; Y++) O[Y] || (O[Y] = 1, O[O.maxIndex()] -= 1);
      let x = 0;
      const I = new Array(g.c + 1).fill("");
      O.forEach((Y, ee) => {
        let B = {};
        ee === O.length - 1 ? B = { s: { r: R, c: x }, e: { r: R, c: g.c } } : B = { s: { r: R, c: x }, e: { r: R, c: x + Y - 1 } }, I[x] = v[ee], x += Y, S.push(B);
      }), _.push(I);
    }
    Yi.utils.sheet_add_aoa(e, _, { skipHeader: true, origin: f, sheetStubs: true });
    for (let R = f; R < m; R++) {
      const v = _[R - f];
      for (let N = 0; N < v.length; N++) {
        const P = Yi.utils.encode_cell({ c: N, r: R });
        e[P].s = { font: { name: "Microsoft YaHei", sz: ul(o.size), color: { rgb: "000000" }, bold: o.bold === "bold", underline: false, outline: false, italic: false, strike: false }, alignment: { vertical: ym(o.verticleAlign), horizontal: mr(o.align), wrapText: false } };
      }
      e["!rows"].splice(f, 0, { hpt: o.size + 10 });
    }
  }
  if (E.footerExtra) {
    const T = c.fields.filter((R) => R.show), _ = [], f = r.footerExtra, m = f + E.footerExtra;
    for (let R = f; R < m; R++) {
      const v = b[R - f], P = T.splice(0, v.length).map((Y) => {
        const ee = A(Y.width) ? Y.width : Y.maxWidth;
        return ta(ee, u.unit);
      }), L = [...h], O = P.map((Y, ee) => {
        let B = true, q = 0, ae = 0;
        for (; B && L.length > 0; ) if (q += L[0], q >= Y && ae !== 0) {
          const j = Math.abs(q - Y), le = Math.abs(q - L[0] - Y);
          j < le && (L.shift(), ae += 1), B = false;
        } else L.shift(), ae += 1;
        return ae;
      });
      for (let Y = 0; Y < O.length; Y++) O[Y] || (O[Y] = 1, O[O.maxIndex()] -= 1);
      let x = 0;
      const I = new Array(g.c + 1).fill("");
      O.forEach((Y, ee) => {
        let B = {};
        ee === O.length - 1 ? B = { s: { r: R, c: x }, e: { r: R, c: g.c } } : B = { s: { r: R, c: x }, e: { r: R, c: x + Y - 1 } }, I[x] = v[ee], x += Y, S.push(B);
      }), _.push(I);
    }
    Yi.utils.sheet_add_aoa(e, _, { skipHeader: true, origin: f, sheetStubs: true });
    for (let R = f; R < m; R++) {
      const v = _[R - f];
      for (let N = 0; N < v.length; N++) {
        const P = Yi.utils.encode_cell({ c: N, r: R });
        e[P].s = { font: { name: "Microsoft YaHei", sz: ul(c.size), color: { rgb: "000000" }, bold: c.bold === "bold", underline: false, outline: false, italic: false, strike: false }, alignment: { vertical: ym(c.verticleAlign), horizontal: mr(c.align), wrapText: false } };
      }
      e["!rows"].splice(f, 0, { hpt: c.size + 10 });
    }
  }
  if (E.tHeader > 1) {
    const T = n.columnRows, _ = r.tHeader;
    n.index.show && S.push({ s: { r: _, c: 0 }, e: { r: _ + T.length - 1, c: 0 } }), T.forEach((f, m) => {
      const R = _ + m;
      let v = 1;
      f.forEach((N) => {
        const P = { s: { r: R, c: v }, e: { r: R + N.rowSpan - 1, c: v + N.colSpan - 1 } };
        v += N.colSpan, S.push(P);
      });
    });
  }
  e["!merges"] = S;
}
function tJ({ config: e, baseCfg: o, ws: n, sr: c, rn: u }) {
  let r = c.title;
  if (!e) return r;
  if (e.show && e.title) {
    const E = [[e.title.replace(/<br\s*\/?>/g, `
`)]];
    r = c.title = r || 0, u.title = 1, Yi.utils.sheet_add_aoa(n, E, { skipHeader: true, origin: r });
    const y = { font: { name: "宋体", sz: ul(e.size), color: { rgb: "000000" }, bold: e.bold === "bold", underline: false, outline: false, italic: false, strike: false }, alignment: { vertical: ym(e.verticleAlign), horizontal: mr(e.align), wrapText: true } }, b = Yi.utils.encode_cell({ c: 0, r });
    return n[b].s = y, n["!rows"].push({ hpx: ta(e.height, o.unit) }), ++r;
  }
  return r;
}
function iJ({ data: e, config: o, ws: n, sr: c, rn: u, headerRows: r }) {
  let E = c.header;
  if (!o) return E;
  const y = [];
  if (o.show && A(o.fields)) {
    const b = o.width;
    let V = 0, M = -1;
    for (const g of o.fields) if (g.show) {
      let S = "";
      A(g.title) && (S += g.title), e && g.key && (S += pc({ row: e, field: g, emptyVal: o.emptyVal }));
      let h = 0;
      A(g.width) ? h += g.width : A(g.maxWidth) && (h += g.maxWidth), V += h, (V > b || M === -1) && (M++, V = h), y[M] || (y[M] = []), y[M].push(S);
    }
    if (M > -1) return E = c.header = E || 0, u.header = M + 1, Object.assign(r, y), Yi.utils.sheet_add_aoa(n, y, { skipHeader: true, origin: E }), E + u.header;
  }
  return E;
}
function aJ(e, o, n) {
  const c = [];
  let { columnRows: u = [] } = n;
  u = JSON.parse(JSON.stringify(u)), n.index.show && u[0].unshift({ ...n.index, colSpan: 1, rowSpan: u.length }), u.forEach((E) => c.push([])), u.forEach((E, y) => {
    const b = c[y];
    E.forEach((V) => {
      b.push(V.title), b.push.apply(b, new Array(V.colSpan - 1).fill(""));
      for (let M = 0; M < V.rowSpan - 1; M++) c[y + 1].push.apply(c[y + 1], new Array(V.colSpan).fill(""));
    });
  }), Yi.utils.sheet_add_aoa(e, c, { skipHeader: true, origin: o.tHeader });
  const r = {};
  return u.forEach((E, y) => {
    r[y + o.tHeader] = 0;
  }), u.forEach((E, y) => {
    E.forEach((b) => {
      for (let V = 0; V < b.rowSpan; V++) {
        const M = o.tHeader + y + V;
        for (let g = 0; g < b.colSpan; g++) {
          const S = r[M] + g, h = Yi.utils.encode_cell({ c: S, r: M });
          e[h].s = { font: { name: "Microsoft YaHei", sz: ul(n.th.size), color: { rgb: "000000" }, bold: n.th.bold === "bold", underline: false, outline: false, italic: false, strike: false }, alignment: { vertical: "center", horizontal: mr(b.align), wrapText: true }, border: zR };
        }
        r[M] += b.colSpan;
      }
    });
  }), o.tHeader = o.tHeader || 0, u.length;
}
function lJ({ data: e, config: o, baseCfg: n, ws: c, sr: u, rn: r }) {
  let E = u.tHeader;
  if (!o) return E;
  if (A(o.lastColumns)) {
    let y = [];
    const b = [], V = [];
    if (r.tHeader = aJ(c, u, o), E = u.tBody = u.tHeader + r.tHeader, y = JSON.parse(JSON.stringify(o.lastColumns)), o.index.show && y.unshift({ ...o.index, key: "__index" }), y.length === 0) return E;
    y.forEach((R) => {
      R.show && (b.push(R.key), V.push(R.title));
    });
    const M = o.summary && o.summary.show, g = {}, S = {}, h = {}, T = y.filter((R) => (g[R.key] = "", R.sum)).map((R) => (g[R.key] = 0, h[R.key] = 0, S[R.key] = [], R.key));
    g.__index = o.summary.title || "合计";
    const _ = e.map((R, v) => {
      const N = {};
      return y.forEach((P) => {
        if (M && T.includes(P.key)) {
          const L = HR(R, P.key);
          S[P.key].push(Ho(L)), isNaN(Number(L)) || (g[P.key] = (g[P.key] || 0) + Number(L));
        }
        N[P.key] = pc({ row: R, field: P, emptyVal: o.emptyVal });
      }), o.index.show && (N.__index = v + 1), N;
    });
    y.forEach((R) => {
      if (R.sum) {
        const v = g[R.key] || 0;
        h[R.key] = S[R.key].getMax(), h[R.key] = h[R.key] > 5 ? 5 : h[R.key];
        const N = JSON.parse(JSON.stringify(R));
        N.format || (N.format = {}), Ae(N.format.precision) && (N.format.precision = h[R.key]), g[R.key] = pc({ val: v, field: N, emptyVal: "", kParse: false });
      }
    }), M && o.index.show && _.push(g), c["!rows"].push({ hpx: ul(o.th.lineHeight) + ta(o.th.paddingTB * 2, n.unit) }), r.tBody = _.length;
    const f = sJ({ baseCfg: n, columns: y, ws: c });
    Yi.utils.sheet_add_json(c, _, { header: f > 0 ? [...b, `blankColumn_${Math.random}`] : b, skipHeader: true, origin: u.tBody });
    const m = u.tBody + _.length;
    for (let R = u.tBody; R < m; R++) {
      for (let v = 0; v < y.length; v++) {
        const N = y[v], P = Yi.utils.encode_cell({ c: v, r: R });
        c[P].s = { font: { name: "Microsoft YaHei", sz: ul(o.td.size), color: { rgb: "000000" }, bold: o.td.bold === "bold", underline: false, outline: false, italic: false, strike: false }, alignment: { vertical: "center", horizontal: mr(N.align), wrapText: true }, border: zR };
      }
      c["!rows"].push({ hpx: ul(o.td.lineHeight) + ta(o.td.paddingTB * 2, n.unit) });
    }
    return m;
  }
  return E;
}
function oJ({ data: e, config: o, baseCfg: n, ws: c, sr: u, rn: r, footerRows: E }) {
  const y = u.all = u.footer;
  if (!o || !o.show) return y;
  const b = o.tip;
  return b && b.show && b.above && (u.all = kb({ config: b, footerCfg: o, baseCfg: n, ws: c, sr: u, rn: r })), A(o.fields) && (u.all = nJ({ data: e, config: o, baseCfg: n, ws: c, sr: u, rn: r, footerRows: E })), b && b.show && !b.above && (u.all = kb({ config: b, footerCfg: o, baseCfg: n, ws: c, sr: u, rn: r })), u.all;
}
function kb({ config: e, footerCfg: o, baseCfg: n, ws: c, sr: u, rn: r }) {
  let E = u.all;
  if (!e) return E;
  if (e.show && e.text) {
    const y = [[e.text]];
    E = u.footerTip = E || 0, r.footerTip = 1, Yi.utils.sheet_add_aoa(c, y, { skipHeader: true, origin: E });
    const b = Yi.utils.encode_cell({ c: 0, r: u.footerTip });
    c[b].s = { font: { name: "Microsoft YaHei", sz: ul(e.size), color: { rgb: "FFFF0000" }, bold: e.bold === "bold", underline: false, outline: false, italic: false, strike: false }, alignment: { vertical: "center", horizontal: mr(e.align), wrapText: true } };
    let V = ta(o.height, n.unit);
    if (A(o.fields)) {
      const M = o.width;
      let g = 0, S = -1;
      for (const h of o.fields) if (h.show) {
        let T = 0;
        A(h.width) ? T += h.width : A(h.maxWidth) && (T += h.maxWidth), g += T, (g > M || S === -1) && (S++, g = T);
      }
      S > -1 && (V -= ul(o.size) * (S + 1));
    }
    return c["!rows"].push({ hpx: V }), ++E;
  }
}
function nJ({ data: e, config: o, ws: n, sr: c, rn: u, footerRows: r }) {
  let E = c.all;
  if (!o) return E;
  const y = [];
  if (o.show && o.fields) {
    const b = o.width;
    let V = 0, M = -1;
    for (const g of o.fields) if (g.show) {
      let S = "";
      A(g.title) && (S += g.title), e && g.key && (S += pc({ row: e, field: g, emptyVal: o.emptyVal }));
      let h = 0;
      A(g.width) ? h += g.width : A(g.maxWidth) && (h += g.maxWidth), V += h, (V > b || M === -1) && (M++, V = h), y[M] || (y[M] = []), y[M].push(S);
    }
    if (M > -1) return E = c.footerExtra = E || 0, u.footerExtra = M + 1, Object.assign(r, y), Yi.utils.sheet_add_aoa(n, y, { skipHeader: true, origin: E }), E + u.footerExtra;
  }
  return E;
}
function sJ({ baseCfg: e, columns: o, ws: n }) {
  const c = [];
  let u = 0, r = 0;
  o.forEach((b) => {
    let V = 0, M = false;
    A(b.width) ? V += b.width : A(b.minWidth) && (V += b.minWidth, M = true, r++), u += V, c.push({ distributable: M, key: b, width: V });
  });
  const E = e.aclWidth - u - St((o.length + 1) / 2, "mm", e.unit);
  let y = 0;
  return E > 0 && r && (y = E / r), c.forEach((b) => {
    let V = b.width;
    y && b.distributable && (V += y), n["!cols"].push({ wpx: ta(V, e.unit), MDW: Em });
  }), E > 0 && !r ? (n["!cols"].push({ wpx: ta(E, e.unit), MDW: Em }), E) : 0;
}
function ym(e) {
  switch (e) {
    case D.TOP.V:
      return "top";
    case D.BOTTOM.V:
      return "bottom";
    case D.CENTER.V:
      return "center";
    default:
      return "top";
  }
}
function mr(e) {
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
function pc({ row: e = {}, val: o, field: n, emptyVal: c = "" }) {
  switch (n.source === i.CUSTOMIZE.V && (c = ""), !A(o) && A(e) && A(n) && (o = HR(e, n.key)), n.type) {
    case a.PROJECT.K:
      return Si(uJ(o, n.format), c);
    case a.DATE.K:
      return Si(Db(o, n.format), c);
    case a.DATES.K:
      return Si(Db(o, n.format), c);
    case a.AMOUNT.K:
      return Si(cJ(o, n.format), c);
    case a.WEIGHT.K:
      return Si(dJ(o, n.format), c);
    case a.LENGTH.K:
      return Si(mJ(o, n.format), c);
    case a.RATE.K:
      return Si(gJ(o, n.format), c);
    case a.THICKNESS.K:
      return Si(pJ(o, n.format), c);
    case a.METE.K:
      return Si(hJ({ val: o, row: e, format: n.format }), c);
    case a.QUANTITY.K:
      return Si(fJ(o, n.format), c);
    case a.ENUM.K:
      return Si(rJ(o, n.format), c);
    case a.IMAGE.K:
      return "";
    default:
      return Si(o, c);
  }
}
function rJ(e, o) {
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
function uJ(e, o = {}) {
  return A(o) || (o = { showProjectFullName: false, showSerialNumber: false, projectNameShowConfig: nt.SERIAL_NUMBER_START.V, lineBreak: true }), di(e, o, o.lineBreak);
}
function Db(e, o = "YY/MM/DD") {
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
function cJ(e, o = {}) {
  let n = e;
  return A(n) && (A(o.unit) && o.unit === We.WAN.V && (n /= 1e4), A(o.precision) && (n = (+n).toFixed(o.precision)), o.toThousand && (n = Mi(n, o.precision ?? Rr))), n;
}
function dJ(e, o = {}) {
  let n = e;
  return A(n) && (A(o.unit) && (n = St(n, rt.WEIGHT, o.unit)), A(o.precision) && (n = (+n).toFixed(o.precision)), o.toThousand && (n = Mi(n, o.precision ?? Rr))), n;
}
function mJ(e, o = {}) {
  let n = e;
  return A(n) && (A(o.unit) && (n = St(n, rt.LENGTH, o.unit)), A(o.precision) && (n = (+n).toFixed(o.precision)), o.toThousand && (n = Mi(n, o.precision ?? Rr))), n;
}
function pJ(e, o = {}) {
  let n = e;
  return A(n) && (A(o.unit) && (n = St(n, Ft.THICKNESS, o.unit)), A(o.precision) && (n = (+n).toFixed(o.precision)), o.toThousand && (n = Mi(n, o.precision ?? Rr))), n;
}
function hJ({ val: e, row: o, format: n = {} }) {
  let c = e;
  return A(c) && (A(n.precision) && (c = (+c).toFixed(n.precision)), n.toThousand && (c = Mi(c, n.precision ?? Rr)), n.showUnit && (n.unit && (c += ` ${n.unit}`), o != null && o[n.rowUnit] && (c += ` ${o[n.rowUnit]}`))), c;
}
function fJ(e, o = {}) {
  let n = e;
  return A(n) && (A(o.precision) && (n = (+n).toFixed(o.precision)), o.toThousand && (n = Mi(n, o.precision ?? Rr))), n;
}
function gJ(e, o = {}) {
  let n = e;
  return A(o.precision) && (n = (+n).toFixed(o.precision)), n + "%";
}
function HR(e, o) {
  if (A(e) && A(o) && typeof o == "string") {
    const c = o.split(".");
    return c.length === 1 ? e[c[0]] : c.reduce((u, r) => en.isPlainObject(u) ? u[r] : void 0, e);
  }
}
const qR = { __name: "index", props: { beforeDownload: { type: Function, default: void 0 }, header: { type: Object, default: () => {
} }, template: { type: Object, required: true }, title: { type: String }, filename: { type: String }, params: { type: null }, size: { type: String, default: "small" }, disabled: { type: Boolean, default: false }, btnName: { type: String, default: "下载" }, btnType: { type: String }, data: { type: Object, default: () => {
} } }, emits: ["end"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(false);
  async function r() {
    u.value = true;
    try {
      if (!await QZ({ ...c.data, config: c.template })) throw new Error("导出失败");
      n("end");
    } catch (E) {
      Di({ title: "导出失败", message: E, type: "error", duration: 2500 }), console.log("导出", E);
    } finally {
      u.value = false;
    }
  }
  return (E, y) => {
    const b = Ve("common-button");
    return w(), U(b, { loading: u.value, size: e.size, disabled: e.disabled, icon: "el-icon-download", type: e.btnType, onClick: r }, { default: p(() => [Te(K(c.btnName), 1)]), _: 1 }, 8, ["loading", "size", "disabled", "type"]);
  };
} }, EJ = Object.freeze(Object.defineProperty({ __proto__: null, default: qR }, Symbol.toStringTag, { value: "Module" })), ts = { __name: "price-set-columns-vxe", props: { weightAttribute: { type: String, default: "weighingTotalWeight" } }, setup(e) {
  const o = e, { handleUnitPriceChange: n, handleAmountChange: c } = Al(o.weightAttribute);
  return (u, r) => {
    const E = Ve("common-input-number"), y = Ve("vxe-column");
    return w(), Q(Qe, null, [s(y, { field: "unitPrice", align: "center", width: "135px", title: "含税单价" }, { default: p(({ row: b }) => [b ? (w(), U(E, { key: 0, modelValue: b.unitPrice, "onUpdate:modelValue": (V) => b.unitPrice = V, min: 0, max: 9999999999, controls: false, style: { width: "100%" }, step: 1, size: "default", placeholder: "含税单价", onChange: (V) => l(n)(V, b) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : H("", true)]), _: 1 }), s(y, { field: "amount", align: "center", width: "135px", title: "金额" }, { default: p(({ row: b }) => [b ? (w(), U(E, { key: 0, modelValue: b.amount, "onUpdate:modelValue": (V) => b.amount = V, min: 0, max: 9999999999, controls: false, style: { width: "100%" }, step: 1, size: "default", precision: l(Ze).YUAN, placeholder: "金额", onChange: (V) => l(c)(V, b) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : H("", true)]), _: 1 })], 64);
  };
} }, yJ = Object.freeze(Object.defineProperty({ __proto__: null, default: ts }, Symbol.toStringTag, { value: "Module" }));
const TJ = { __name: "steel-plate-table", props: { form: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, list: { type: Array, default: () => [] } }, setup(e, { expose: o }) {
  const n = e, c = Ge.STEEL_PLATE.V, { baseUnit: u } = ai(c), { overDiffTip: r, weightOverDiff: E, diffSubmitValidate: y } = Va(u), b = Z(false), V = Z([]), M = Z({ resizable: true }), g = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: true }), h = { width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: Vi, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { pattern: Vi, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: y, message: "超出误差允许范围,不可提交", trigger: "blur" }, { validator: (Y, ee) => A(Y) ? Y > 0 : true, message: "重量必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { pattern: Vi, message: "长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: Vi, message: "数量必须大于0", trigger: "blur" }] }, T = Ee(() => Object.assign({}, h)), _ = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1]]), { tableValidate: f, cleanUpData: m, wrongCellMask: R } = ui({ rules: T, ditto: _, errorMsg: "请修正【钢板清单】中标红的信息" });
  function v(Y) {
    return N(Y), Y;
  }
  Ce(() => n.list, (Y) => {
    A(n.list) ? V.value = JSON.parse(JSON.stringify(n.list)) : V.value = [], V.value.forEach((ee) => {
      N(ee);
    });
  }, { deep: true, immediate: true });
  function N(Y) {
    Dt(() => {
      E(Y);
    }), Ce([() => Y.length, () => Y.width, () => Y.thickness, u], () => P(Y)), Ce([() => Y.theoryWeight, () => Y.quantity], () => L(Y)), Ce(() => Y.weighingTotalWeight, () => {
      O(Y);
    });
  }
  async function P(Y) {
    Y.theoryWeight = await na({ classifyId: Y.classifyId, name: Y.classifyFullName, length: Y.length, width: Y.width, thickness: Y.thickness });
  }
  function L(Y) {
    A(Y.theoryWeight) && Y.quantity ? (Y.theoryTotalWeight = Be(Y.theoryWeight * Y.quantity, u.value.weight.precision), Y.weighingTotalWeight = Be(Y.theoryWeight * Y.quantity, u.value.weight.precision)) : (Y.theoryTotalWeight = void 0, Y.weighingTotalWeight = void 0);
  }
  function O(Y) {
    A(Y.unitPrice) && A(Y.weighingTotalWeight) ? Y.amount = Be(Y.weighingTotalWeight * Y.unitPrice, Ze.YUAN) : Y.amount = void 0;
  }
  function x(Y, ee, B) {
    if (V.value.splice(ee, 1), A(V.value) && V.value.length > 0) {
      const q = V.value[0];
      V.value[0].projectId = q.projectId && q.projectId !== -1 ? q.projectId : void 0, V.value[0].workshopId = q.workshopId && q.workshopId !== -1 ? q.workshopId : void 0;
    }
  }
  function I() {
    if (Ae(V.value)) return ot.error("明细不能为空"), false;
    const Y = V.value.filter((B, q) => (B.dataIndex = q, true)), { validResult: ee } = f(Y);
    return ee && (m(Y), Y.forEach((B) => {
      var q;
      V.value[B.dataIndex].projectId = B.projectId, V.value[B.dataIndex].workshopId = B.workshopId || ((q = B.workshop) == null ? void 0 : q.id);
    })), ee;
  }
  return o({ rowInit: v, rowWatch: N, validate: I, tableList: V }), (Y, ee) => {
    const B = Ve("vxe-column"), q = jt, ae = Ve("vxe-tooltip"), j = Ve("common-input-number"), le = Mt, oe = Ve("common-radio-button"), ye = Ve("common-button"), ce = Ve("vxe-table"), se = _t("empty-text"), he = oi;
    return qe((w(), Q("div", null, [(w(), U(ce, { key: `import_${l(c)}`, "cell-class-name": l(R), "column-config": M.value, data: V.value, "empty-text": "暂无数据", "max-height": e.maxHeight, "scroll-y": g.value, border: "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(B, { title: "序号", type: "seq", width: "55" }), s(B, { align: "center", title: "申购单号", "min-width": "110px", field: "purchaseSN" }), s(B, { align: "center", title: "标识", "min-width": "120px", field: "uid" }, { default: p(({ row: be }) => [s(q, { content: be.uid, placement: "top" }, { default: p(() => [C("span", null, K(be.uid), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(B, { align: "center", title: "编号", "min-width": "110px", field: "serialNumber" }), s(B, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: be }) => [s(ae, { content: be.classifyParentFullName, disabled: !be.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[se, be.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(B, { align: "center", field: "material", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: be }) => [s(ae, { content: be.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(be.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(B, { title: `厚 (${l(u).thickness.unit})`, align: "center", "min-width": "100px", field: "thickness" }, { default: p(({ row: be }) => [s(j, { modelValue: be.thickness, "onUpdate:modelValue": (me) => be.thickness = me, controls: false, max: 99999999, min: 0, style: { width: "100%" }, precision: l(u).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(B, { title: `宽 (${l(u).width.unit})`, align: "center", "min-width": "135px", field: "width" }, { default: p(({ row: be }) => [s(j, { modelValue: be.width, "onUpdate:modelValue": (me) => be.width = me, controls: false, max: 99999999, min: 0, precision: l(u).width.precision, size: "default", style: { width: "100%" }, "controls-position": "right", placeholder: "宽" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(B, { title: `长 (${l(u).length.unit})`, align: "center", "min-width": "135px", field: "length" }, { default: p(({ row: be }) => [s(j, { modelValue: be.length, "onUpdate:modelValue": (me) => be.length = me, controls: false, max: 99999999, min: 0, precision: l(u).length.precision, size: "default", style: { width: "100%" }, placeholder: "长" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(B, { title: `数量 (${l(u).measure.unit})`, align: "center", "min-width": "135px", field: "quantity" }, { default: p(({ row: be }) => [s(j, { modelValue: be.quantity, "onUpdate:modelValue": (me) => be.quantity = me, controls: false, max: 999999999, min: 1, precision: l(u).measure.precision, size: "default", style: { width: "100%" }, step: 1, "controls-position": "right", placeholder: "数量" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(B, { key: "weighingTotalWeight", title: `总重 (${l(u).weight.unit})`, align: "center", "min-width": "135px", field: "weighingTotalWeight" }, { default: p(({ row: be }) => [s(q, { content: `理论重量：${be.theoryTotalWeight} kg， ${l(r)}`, disabled: !be.hasOver, class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(j, { modelValue: be.weighingTotalWeight, "onUpdate:modelValue": (me) => be.weighingTotalWeight = me, class: Zt({ "over-weight-tip": be.hasOver }), controls: false, max: 999999999, min: 0, style: { width: "100%" }, precision: l(u).weight.precision, size: "default", "controls-position": "right", placeholder: "重量" }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision"])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["title"]), s(ts), s(B, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: be }) => [s(le, { modelValue: be.brand, "onUpdate:modelValue": (me) => be.brand = me, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(B, { align: "center", field: "weightMeasurementMode", title: "计量方式", width: "140" }, { default: p(({ row: be }) => [s(oe, { modelValue: be.weightMeasurementMode, "onUpdate:modelValue": (me) => be.weightMeasurementMode = me, options: l(Wt).ENUM, props: { key: "K", label: "SL", value: "V" }, "unshow-val": [l(Wt).MIXTURE.V], default: "", size: "default", type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "unshow-val"])]), _: 1 }), e.form.orderPlace === l(Bt).FACTORY.V ? (w(), U(B, { key: 0, align: "center", field: "projectId", title: "所属项目", width: "140" }, { default: p(({ row: be, rowIndex: me }) => [s(l(ca), { modelValue: be.projectId, "onUpdate:modelValue": (ge) => be.projectId = ge, "show-extra": me !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra"])]), _: 1 })) : H("", true), e.form.orderPlace === l(Bt).FACTORY.V ? (w(), U(B, { key: 1, align: "center", field: "projectId", title: "仓库", width: "140" }, { default: p(({ row: be, rowIndex: me }) => [s(Ul, { modelValue: be.workshopId, "onUpdate:modelValue": (ge) => be.workshopId = ge, "show-extra": me !== 0, placeholder: "请选择仓库", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra"])]), _: 1 })) : H("", true), s(B, { align: "center", fixed: "right", title: "操作", width: "100" }, { default: p(({ row: be, rowIndex: me }) => [s(ye, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (ge) => x(be.sn, me, be) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y"]))])), [[he, b.value]]);
  };
} }, GR = ut(TJ, [["__scopeId", "data-v-3510d86d"]]), _J = Object.freeze(Object.defineProperty({ __proto__: null, default: GR }, Symbol.toStringTag, { value: "Module" }));
const bJ = { style: { overflow: "hidden" } }, VJ = { __name: "section-steel-table", props: { form: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, list: { type: Array, default: () => [] } }, setup(e, { expose: o }) {
  const n = e, c = Ge.SECTION_STEEL.V, { baseUnit: u } = ai(c), r = Z(false), E = Z([]), y = Z({ resizable: true }), b = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: true }), { overDiffTip: V, weightOverDiff: M, diffSubmitValidate: g } = Va(u), S = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], length: [{ required: true, message: "请填写定尺长度", trigger: "blur" }, { pattern: Vi, message: "定尺长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: Vi, message: "数量必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: g, message: "超出误差允许范围,不可提交", trigger: "blur" }, { pattern: Vi, message: "重量必须大于0", trigger: "blur" }] }, h = Ee(() => Object.assign({}, S)), T = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1]]), { tableValidate: _, cleanUpData: f, wrongCellMask: m } = ui({ rules: h, ditto: T, errorMsg: "请修正【型材清单】中标红的信息" });
  function R(Y) {
    return v(Y), Y;
  }
  Ce(() => n.list, (Y) => {
    A(n.list) ? E.value = JSON.parse(JSON.stringify(n.list)) : E.value = [], E.value.forEach((ee) => {
      v(ee);
    });
  }, { deep: true, immediate: true });
  function v(Y) {
    Dt(() => {
      M(Y), Y.needFirstCalcTheoryWeight && (N(Y), L(Y), Y.needFirstCalcTheoryWeight = false);
    }), Ce([() => Y.length, () => Y.unitWeight, u], () => N(Y)), Ce([() => Y.theoryWeight, () => Y.quantity], () => {
      L(Y);
    }), Ce(() => Y.weighingTotalWeight, () => {
      O(Y);
    }), Ce([() => Y.length, () => Y.quantity], () => {
      P(Y);
    });
  }
  async function N(Y) {
    Y.theoryWeight = await xa({ length: Y.length, unitWeight: Y.unitWeight });
  }
  function P(Y) {
    A(Y.length) && Y.quantity ? Y.totalLength = Na({ length: Y.length, quantity: Y.quantity }) : Y.totalLength = void 0;
  }
  function L(Y) {
    console.log(Y, "row11111"), A(Y.theoryWeight) && Y.quantity ? (Y.theoryTotalWeight = Be(Y.theoryWeight * Y.quantity, u.value.weight.precision), Y.weighingTotalWeight = Be(Y.theoryWeight * Y.quantity, u.value.weight.precision)) : (Y.theoryTotalWeight = void 0, Y.weighingTotalWeight = void 0);
  }
  function O(Y) {
    A(Y.unitPrice) && A(Y.weighingTotalWeight) && (Y.amount = Be(Y.weighingTotalWeight * Y.unitPrice, Ze.YUAN));
  }
  function x(Y, ee, B) {
    if (E.value.splice(ee, 1), A(E) && E.value.length > 0) {
      const q = E.value[0];
      E.value[0].projectId = q.projectId && q.projectId !== -1 ? q.projectId : void 0, E.value[0].workshopId = q.workshopId && q.workshopId !== -1 ? q.workshopId : void 0;
    }
  }
  function I() {
    if (Ae(E.value)) return ot.error("明细不能为空"), false;
    const Y = E.value.filter((B, q) => (B.dataIndex = q, true));
    if (Ae(Y)) return true;
    const { validResult: ee } = _(Y);
    return ee && (f(Y), Y.forEach((B) => {
      var q, ae;
      E.value[B.dataIndex].projectId = B.projectId, E.value[B.dataIndex].workshopId = B.workshopId || ((q = B.workshop) == null ? void 0 : q.id), E.value[B.dataIndex].warehouseId = B.warehouseId || ((ae = B.warehouse) == null ? void 0 : ae.id);
    })), ee;
  }
  return o({ rowInit: R, rowWatch: v, validate: I, tableList: E }), (Y, ee) => {
    const B = Ve("vxe-column"), q = Ve("vxe-tooltip"), ae = Ve("common-input-number"), j = jt, le = Mt, oe = Ve("common-radio-button"), ye = Ve("common-button"), ce = Ve("vxe-table"), se = _t("empty-text"), he = oi;
    return qe((w(), Q("div", bJ, [(w(), U(ce, { key: `import_${l(c)}`, "cell-class-name": l(m), "column-config": y.value, data: E.value, "empty-text": "暂无数据", "max-height": e.maxHeight, "scroll-y": b.value, border: "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(B, { title: "序号", type: "seq", width: "55" }), s(B, { align: "center", title: "申购单号", "min-width": "110px", field: "purchaseSN" }), s(B, { align: "center", title: "标识", "min-width": "110px", field: "uid" }), s(B, { align: "center", title: "编号", "min-width": "110px", field: "serialNumber" }), s(B, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: be }) => [s(q, { content: be.classifyParentFullName, disabled: !be.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[se, be.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(B, { align: "center", field: "specification", "min-width": "120", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: be }) => [s(q, { content: be.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(be.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(B, { title: `定尺长度 (${l(u).length.unit})`, align: "center", field: "length", "min-width": "120" }, { default: p(({ row: be }) => [s(ae, { modelValue: be.length, "onUpdate:modelValue": (me) => be.length = me, controls: false, max: 99999999, min: 0, precision: l(u).length.precision, placeholder: "长", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(B, { title: `数量 （${l(u).measure.unit})`, align: "center", field: "quantity", "min-width": "120" }, { default: p(({ row: be }) => [s(ae, { modelValue: be.quantity, "onUpdate:modelValue": (me) => be.quantity = me, controls: false, max: 99999999, min: 0, precision: l(u).measure.precision, placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(B, { title: "总长度 (m)", align: "center", "min-width": "135px", field: "totalLength" }), s(B, { title: `总重 (${l(u).weight.unit})`, align: "center", field: "weighingTotalWeight", "min-width": "120" }, { default: p(({ row: be }) => [s(j, { content: `单位重量：${be.unitWeight} kg/m， 理论重量：${be.theoryTotalWeight} kg， ${l(V)}`, disabled: !be.hasOver, class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(ae, { modelValue: be.weighingTotalWeight, "onUpdate:modelValue": (me) => be.weighingTotalWeight = me, class: Zt({ "over-weight-tip": be.hasOver }), controls: false, max: 99999999, min: 0, precision: l(u).weight.precision, placeholder: "总重", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision"])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["title"]), s(ts), s(B, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: be }) => [s(le, { modelValue: be.brand, "onUpdate:modelValue": (me) => be.brand = me, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(B, { align: "center", field: "weightMeasurementMode", title: "计量方式", width: "140" }, { default: p(({ row: be }) => [s(oe, { modelValue: be.weightMeasurementMode, "onUpdate:modelValue": (me) => be.weightMeasurementMode = me, options: l(Wt).ENUM, props: { key: "K", label: "SL", value: "V" }, "unshow-val": [l(Wt).MIXTURE.V], default: "", size: "default", type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "unshow-val"])]), _: 1 }), e.form.orderPlace === l(Bt).FACTORY.V ? (w(), U(B, { key: 0, align: "center", field: "projectId", title: "所属项目", width: "140" }, { default: p(({ row: be, rowIndex: me }) => [s(l(ca), { modelValue: be.projectId, "onUpdate:modelValue": (ge) => be.projectId = ge, "show-extra": me !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra"])]), _: 1 })) : H("", true), e.form.orderPlace === l(Bt).FACTORY.V ? (w(), U(B, { key: 1, align: "center", field: "projectId", title: "仓库", width: "140" }, { default: p(({ row: be, rowIndex: me }) => [s(Ul, { modelValue: be.workshopId, "onUpdate:modelValue": (ge) => be.workshopId = ge, "show-extra": me !== 0, placeholder: "请选择仓库", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra"])]), _: 1 })) : H("", true), s(B, { align: "center", fixed: "right", title: "操作", width: "100" }, { default: p(({ row: be, rowIndex: me }) => [s(ye, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (ge) => x(be.sn, me, be) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y"]))])), [[he, r.value]]);
  };
} }, QR = ut(VJ, [["__scopeId", "data-v-6f0b8471"]]), wJ = Object.freeze(Object.defineProperty({ __proto__: null, default: QR }, Symbol.toStringTag, { value: "Module" }));
const SJ = { style: { overflow: "hidden" } }, vJ = { __name: "steel-coil-table", props: { form: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, list: { type: Array, default: () => [] } }, setup(e, { expose: o }) {
  const n = e, c = Ge.STEEL_COIL.V, u = Z(false), r = Z([]), E = Z({ resizable: true }), y = Z({ enabled: true, gt: 0, oSize: 5, scrollToTopOnChange: true, immediate: true }), b = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: Vi, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { pattern: Vi, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: Vi, message: "重量必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { pattern: Vi, message: "长度必须大于0", trigger: "blur" }] }, V = Ee(() => Object.assign({}, b)), { baseUnit: M } = ai(c), g = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1]]), { tableValidate: S, cleanUpData: h, wrongCellMask: T } = ui({ rules: V, ditto: g, errorMsg: "请修正【钢卷清单】中标红的信息" });
  function _(L) {
    return f(L), L;
  }
  Ce(() => n.list, (L) => {
    A(n.list) ? r.value = JSON.parse(JSON.stringify(n.list)) : r.value = [], r.value.forEach((O) => {
      f(O);
    });
  }, { deep: true, immediate: true });
  function f(L) {
    Ce([() => L.weighingTotalWeight, () => L.width, () => L.thickness, M], () => m(L)), Ce([() => L.theoryLength], () => R(L)), Ce(() => L.weighingTotalWeight, () => {
      v(L);
    });
  }
  async function m(L) {
    L.theoryLength = await il({ classifyId: L.classifyId, name: L.classifyFullName, weight: L.weighingTotalWeight, width: L.width, thickness: L.thickness });
  }
  function R(L) {
    A(L.theoryLength) ? L.length = L.theoryLength * 1 : L.length = void 0;
  }
  function v(L) {
    A(L.unitPrice) && A(L.weighingTotalWeight) ? L.amount = Be(L.weighingTotalWeight * L.unitPrice, Ze.YUAN) : L.amount = void 0;
  }
  function N(L, O, x) {
    if (r.value.splice(O, 1), A(r) && r.value.length > 0) {
      const I = r.value[0];
      r.value[0].projectId = I.projectId && I.projectId !== -1 ? I.projectId : void 0, r.value[0].workshopId = I.workshopId && I.workshopId !== -1 ? I.workshopId : void 0;
    }
  }
  function P() {
    if (Ae(r.value)) return ot.error("明细不能为空"), false;
    const L = r.value.filter((x, I) => (x.dataIndex = I, true));
    if (Ae(L)) return true;
    const { validResult: O } = S(L);
    return O && (h(L), L.forEach((x) => {
      var I, Y;
      r.value[x.dataIndex].projectId = x.projectId, r.value[x.dataIndex].workshopId = x.workshopId || ((I = x.workshop) == null ? void 0 : I.id), r.value[x.dataIndex].warehouseId = x.warehouseId || ((Y = x.warehouse) == null ? void 0 : Y.id);
    })), O;
  }
  return o({ rowInit: _, rowWatch: f, validate: P, tableList: r }), (L, O) => {
    const x = Ve("vxe-column"), I = Ve("vxe-tooltip"), Y = Ve("common-input-number"), ee = Mt, B = Ve("common-button"), q = Ve("vxe-table"), ae = _t("empty-text"), j = oi;
    return qe((w(), Q("div", SJ, [(w(), U(q, { key: `import_${l(c)}`, "cell-class-name": l(T), "column-config": E.value, data: r.value, "empty-text": "暂无数据", "max-height": e.maxHeight, "scroll-y": y.value, border: "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(x, { title: "序号", type: "seq", width: "55" }), s(x, { align: "center", title: "申购单号", "min-width": "110px", field: "purchaseSN" }), s(x, { align: "center", title: "标识", "min-width": "110px", field: "uid" }), s(x, { align: "center", title: "编号", "min-width": "110px", field: "serialNumber" }), s(x, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: le }) => [s(I, { content: le.classifyParentFullName, disabled: !le.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[ae, le.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(x, { align: "center", field: "material", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: le }) => [s(I, { content: le.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(le.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(x, { title: `总重 (${l(M).weight.unit})`, align: "center", field: "weighingTotalWeight", "min-width": "120" }, { default: p(({ row: le }) => [s(Y, { modelValue: le.weighingTotalWeight, "onUpdate:modelValue": (oe) => le.weighingTotalWeight = oe, controls: false, max: 99999999, min: 0, precision: l(M).weight.precision, placeholder: "总重", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(x, { title: `厚 (${l(M).thickness.unit})`, align: "center", field: "thickness", "min-width": "120" }, { default: p(({ row: le }) => [s(Y, { modelValue: le.thickness, "onUpdate:modelValue": (oe) => le.thickness = oe, controls: false, max: 99999999, min: 0, precision: l(M).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(x, { title: `宽 (${l(M).width.unit})`, align: "center", field: "width", "min-width": "120" }, { default: p(({ row: le }) => [s(Y, { modelValue: le.width, "onUpdate:modelValue": (oe) => le.width = oe, controls: false, max: 99999999, min: 0, precision: l(M).width.precision, "controls-position": "right", placeholder: "宽", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(x, { title: `长度 (${l(M).length.unit})`, align: "center", field: "length", "min-width": "120" }, { default: p(({ row: le }) => [s(Y, { modelValue: le.length, "onUpdate:modelValue": (oe) => le.length = oe, controls: false, max: 99999999, min: 0, precision: l(M).length.precision, placeholder: "长", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(ts), s(x, { align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: le }) => [s(ee, { modelValue: le.color, "onUpdate:modelValue": (oe) => le.color = oe, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(x, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: le }) => [s(ee, { modelValue: le.brand, "onUpdate:modelValue": (oe) => le.brand = oe, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(x, { align: "center", field: "heatNoAndBatchNo", title: "卷号", width: "120" }, { default: p(({ row: le }) => [s(ee, { modelValue: le.heatNoAndBatchNo, "onUpdate:modelValue": (oe) => le.heatNoAndBatchNo = oe, modelModifiers: { trim: true }, maxlength: "60", placeholder: "炉批号", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), e.form.orderPlace === l(Bt).FACTORY.V ? (w(), U(x, { key: 0, align: "center", field: "projectId", title: "所属项目", width: "140" }, { default: p(({ row: le, rowIndex: oe }) => [s(l(ca), { modelValue: le.projectId, "onUpdate:modelValue": (ye) => le.projectId = ye, "show-extra": oe !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra"])]), _: 1 })) : H("", true), e.form.orderPlace === l(Bt).FACTORY.V ? (w(), U(x, { key: 1, align: "center", field: "projectId", title: "仓库", width: "140" }, { default: p(({ row: le, rowIndex: oe }) => [s(Ul, { modelValue: le.workshopId, "onUpdate:modelValue": (ye) => le.workshopId = ye, "show-extra": oe !== 0, placeholder: "请选择仓库", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra"])]), _: 1 })) : H("", true), s(x, { align: "center", fixed: "right", title: "操作", width: "100" }, { default: p(({ row: le, rowIndex: oe }) => [s(B, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (ye) => N(le.sn, oe, le) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y"]))])), [[j, u.value]]);
  };
} }, ZR = ut(vJ, [["__scopeId", "data-v-9eb46b07"]]), RJ = Object.freeze(Object.defineProperty({ __proto__: null, default: ZR }, Symbol.toStringTag, { value: "Module" }));
const MJ = { style: { overflow: "hidden" } }, AJ = { key: 1 }, NJ = { __name: "other-steel-material-table", props: { form: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, list: { type: Array, default: () => [] } }, setup(e, { expose: o }) {
  const n = e, c = Pe.OTHER_STEEL_MATERIALS.V, u = Z(false), r = Z([]), E = Z({ resizable: true }), y = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: true }), M = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (L, O) => O.measureUnit ? !!L : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (L, O) => A(L) ? L > 0 : true, message: "核算量必须大于0", trigger: "blur" }] }, g = Ee(() => Object.assign({}, M)), S = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1]]), { tableValidate: h, cleanUpData: T, wrongCellMask: _ } = ui({ rules: g, ditto: S, errorMsg: "请修正【其它钢材清单】中标红的信息" });
  function f(L) {
    return L;
  }
  Ce(() => n.list, (L) => {
    A(n.list) ? r.value = JSON.parse(JSON.stringify(n.list)) : r.value = [], r.value.forEach((O) => {
      m(O);
    });
  }, { deep: true, immediate: true });
  function m(L) {
    Ce(() => L.mete, () => {
      R(L.mete, L);
    });
  }
  function R(L, O, x) {
    A(O.unitPrice) && A(L) ? O.amount = Be(L * O.unitPrice, Ze.YUAN) : O.amount = void 0, N(O, x || O);
  }
  function v(L, O, x) {
    if (r.value.splice(O, 1), A(r) && r.value.length > 0) {
      const I = r.value[0];
      r.value[0].projectId = I.projectId && I.projectId !== -1 ? I.projectId : void 0, r.value[0].workshopId = I.workshopId && I.workshopId !== -1 ? I.workshopId : void 0;
    }
  }
  function N(L, { accountingUnitNet: O, measurePrecision: x }) {
    !n.boolPartyA && L.measureUnit && O && (L.quantity = Be(L.mete * O, x));
  }
  function P() {
    if (Ae(r.value)) return ot.error("明细不能为空"), false;
    const L = r.value.filter((x, I) => (x.dataIndex = I, true));
    if (Ae(L)) return true;
    const { validResult: O } = h(L);
    return O && (T(L), L.forEach((x) => {
      var I, Y;
      r.value[x.dataIndex].projectId = x.projectId, r.value[x.dataIndex].workshopId = x.workshopId || ((I = x.workshop) == null ? void 0 : I.id), r.value[x.dataIndex].warehouseId = x.warehouseId || ((Y = x.warehouse) == null ? void 0 : Y.id), r.value[x.dataIndex].quantity = x.measureUnit && A(x.measurePrecision) ? x.quantity : void 0;
    })), O;
  }
  return o({ rowInit: f, rowWatch: m, validate: P, tableList: r }), (L, O) => {
    const x = Ve("vxe-column"), I = Ve("vxe-tooltip"), Y = Ve("common-input-number"), ee = Mt, B = Ve("common-button"), q = Ve("vxe-table"), ae = _t("empty-text"), j = oi;
    return qe((w(), Q("div", MJ, [(w(), U(q, { key: `import_${l(c)}`, "cell-class-name": l(_), "column-config": E.value, data: r.value, "empty-text": "暂无数据", "max-height": e.maxHeight, "scroll-y": y.value, border: "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(x, { title: "序号", type: "seq", width: "55" }), s(x, { align: "center", title: "申购单号", "min-width": "110px", field: "purchaseSN" }), s(x, { align: "center", title: "标识", "min-width": "110px", field: "uid" }), s(x, { align: "center", title: "编号", "min-width": "110px", field: "serialNumber" }), s(x, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: le }) => [s(I, { content: le.classifyParentFullName, disabled: !le.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[ae, le.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(x, { align: "center", field: "specification", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: le }) => [s(I, { content: le.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(le.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(x, { align: "center", field: "measureUnit", "min-width": "100", title: "计量单位" }, { default: p(({ row: le }) => [C("span", null, K(le.measureUnit || "-"), 1)]), _: 1 }), s(x, { align: "center", field: "quantity", "min-width": "135px", title: "数量" }, { default: p(({ row: le }) => [l(A)(le.measureUnit) ? (w(), U(Y, { key: 0, modelValue: le.quantity, "onUpdate:modelValue": (oe) => le.quantity = oe, controls: false, max: 999999999, min: 0, precision: le.measurePrecision, step: 1, placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", AJ, K(le.quantity), 1))]), _: 1 }), s(x, { align: "center", field: "accountingUnit", "min-width": "100", title: "核算单位" }, { default: p(({ row: le }) => [C("span", null, K(le.accountingUnit || "-"), 1)]), _: 1 }), s(x, { align: "center", field: "mete", "min-width": "120px", title: "核算量" }, { default: p(({ row: le }) => [s(Y, { modelValue: le.mete, "onUpdate:modelValue": (oe) => le.mete = oe, controls: false, max: 999999999, min: 1e-6, precision: le.accountingPrecision, step: 1, placeholder: "核算量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), s(ts, { "weight-attribute": "mete" }), s(x, { align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: le }) => [s(ee, { modelValue: le.color, "onUpdate:modelValue": (oe) => le.color = oe, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(x, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: le }) => [s(ee, { modelValue: le.brand, "onUpdate:modelValue": (oe) => le.brand = oe, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), e.form.orderPlace === l(Bt).FACTORY.V ? (w(), U(x, { key: 0, align: "center", field: "projectId", title: "所属项目", width: "140" }, { default: p(({ row: le, rowIndex: oe }) => [s(l(ca), { modelValue: le.projectId, "onUpdate:modelValue": (ye) => le.projectId = ye, "show-extra": oe !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra"])]), _: 1 })) : H("", true), e.form.orderPlace === l(Bt).FACTORY.V ? (w(), U(x, { key: 1, align: "center", field: "projectId", title: "仓库", width: "140" }, { default: p(({ row: le, rowIndex: oe }) => [s(Ul, { modelValue: le.workshopId, "onUpdate:modelValue": (ye) => le.workshopId = ye, "show-extra": oe !== 0, placeholder: "请选择仓库", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra"])]), _: 1 })) : H("", true), s(x, { align: "center", fixed: "right", title: "操作", width: "100" }, { default: p(({ row: le, rowIndex: oe }) => [s(B, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (ye) => v(le.sn, oe, le) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y"]))])), [[j, u.value]]);
  };
} }, JR = ut(NJ, [["__scopeId", "data-v-433f7bc7"]]), LJ = Object.freeze(Object.defineProperty({ __proto__: null, default: JR }, Symbol.toStringTag, { value: "Module" }));
const IJ = { __name: "auxiliary-material", props: { form: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, list: { type: Array, default: () => [] }, basicClass: { type: Number, default: Ge.MATERIAL.V } }, setup(e, { expose: o }) {
  const n = e, c = Z(false), u = Z([]), r = Z({ resizable: true }), E = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: false, threshold: 80 }), V = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (P, L) => L.measureUnit && A(L.measurePrecision) ? !!P : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (P, L) => A(P) ? P > 0 : true, message: "核算量必须大于0", trigger: "blur" }] }, M = Ee(() => Object.assign({}, V)), g = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1]]), { tableValidate: S, cleanUpData: h, wrongCellMask: T } = ui({ rules: M, ditto: g });
  function _(P) {
    return P;
  }
  Ce(() => n.list, (P) => {
    A(n.list) ? u.value = JSON.parse(JSON.stringify(n.list)) : u.value = [], u.value.forEach((L) => {
      f(L);
    });
  }, { deep: true, immediate: true });
  function f(P) {
    Ce(() => P.mete, () => {
      m(P.mete, P);
    });
  }
  function m(P, L, O) {
    A(L.unitPrice) && A(P) ? L.amount = Be(P * L.unitPrice, Ze.YUAN) : L.amount = void 0, v(L, O || L);
  }
  function R(P, L, O) {
    if (u.value.splice(L, 1), A(u) && u.value.length > 0) {
      const x = u.value[0];
      u.value[0].projectId = x.projectId && x.projectId !== -1 ? x.projectId : void 0, u.value[0].workshopId = x.workshopId && x.workshopId !== -1 ? x.workshopId : void 0;
    }
  }
  function v(P, { accountingUnitNet: L, measurePrecision: O }) {
    !n.boolPartyA && P.measureUnit && L && (P.quantity = Be(P.mete * L, O));
  }
  function N() {
    if (Ae(u.value)) return ot.error("明细不能为空"), false;
    const P = u.value.filter((O, x) => (O.dataIndex = x, true)), { validResult: L } = S(P);
    return L && (h(P), P.forEach((O) => {
      var x, I;
      u.value[O.dataIndex].projectId = O.projectId, u.value[O.dataIndex].workshopId = O.workshopId || ((x = O.workshop) == null ? void 0 : x.id), u.value[O.dataIndex].warehouseId = O.warehouseId || ((I = O.warehouse) == null ? void 0 : I.id), u.value[O.dataIndex].quantity = O.measureUnit && A(O.measurePrecision) ? O.quantity : void 0;
    })), L;
  }
  return o({ rowInit: _, rowWatch: f, validate: N, tableList: u }), (P, L) => {
    const O = Ve("vxe-column"), x = Ve("vxe-tooltip"), I = Ve("common-input-number"), Y = Mt, ee = Ve("common-button"), B = Ve("vxe-table"), q = _t("empty-text"), ae = oi;
    return w(), Q("div", null, [qe((w(), Q("div", null, [(w(), U(B, { key: `import_${e.basicClass}`, "cell-class-name": l(T), "column-config": r.value, data: u.value, "empty-text": "暂无数据", "max-height": e.maxHeight, "scroll-y": E.value, border: "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(O, { title: "序号", type: "seq", width: "55" }), s(O, { align: "center", title: "申购单号", "min-width": "110px", field: "purchaseSN" }), s(O, { align: "center", title: "标识", "min-width": "110px", field: "uid" }), s(O, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: j }) => [s(x, { content: j.classifyParentFullName, disabled: !j.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[q, j.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(O, { align: "center", field: "specification", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: j }) => [s(x, { content: j.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(j.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(O, { align: "center", field: "measureUnit", "min-width": "100", title: "计量单位" }, { default: p(({ row: j }) => [C("span", null, K(j.measureUnit || "-"), 1)]), _: 1 }), s(O, { align: "center", field: "quantity", "min-width": "135px", title: "数量" }, { default: p(({ row: j }) => [l(A)(j.measureUnit) ? (w(), U(I, { key: 0, modelValue: j.quantity, "onUpdate:modelValue": (le) => j.quantity = le, controls: false, max: 999999999, min: 0, precision: j.measurePrecision, step: 1, placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : H("", true)]), _: 1 }), s(O, { align: "center", field: "accountingUnit", "min-width": "100", title: "核算单位" }, { default: p(({ row: j }) => [C("span", null, K(j.accountingUnit || "-"), 1)]), _: 1 }), s(O, { align: "center", field: "mete", "min-width": "120px", title: "核算量" }, { default: p(({ row: j }) => [s(I, { modelValue: j.mete, "onUpdate:modelValue": (le) => j.mete = le, controls: false, max: 999999999, min: 1e-6, precision: j.accountingPrecision, step: 1, placeholder: "核算量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), s(ts, { "weight-attribute": "mete" }), P.showColor ? (w(), U(O, { key: 0, align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: j }) => [s(Y, { modelValue: j.color, "onUpdate:modelValue": (le) => j.color = le, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : H("", true), s(O, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: j }) => [s(Y, { modelValue: j.brand, "onUpdate:modelValue": (le) => j.brand = le, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), e.form.orderPlace === l(Bt).FACTORY.V ? (w(), U(O, { key: 1, align: "center", field: "projectId", title: "所属项目", width: "140" }, { default: p(({ row: j, rowIndex: le }) => [s(l(ca), { modelValue: j.projectId, "onUpdate:modelValue": (oe) => j.projectId = oe, "show-extra": le !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra"])]), _: 1 })) : H("", true), e.form.orderPlace === l(Bt).FACTORY.V ? (w(), U(O, { key: 2, align: "center", field: "projectId", title: "仓库", width: "140" }, { default: p(({ row: j, rowIndex: le }) => [s(Ul, { modelValue: j.workshopId, "onUpdate:modelValue": (oe) => j.workshopId = oe, "show-extra": le !== 0, placeholder: "请选择仓库", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra"])]), _: 1 })) : H("", true), s(O, { align: "center", fixed: "right", title: "操作", width: "100" }, { default: p(({ row: j, rowIndex: le }) => [s(ee, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (oe) => R(j.sn, le, j) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y"]))])), [[ae, c.value]])]);
  };
} }, XR = ut(IJ, [["__scopeId", "data-v-be63a033"]]), CJ = Object.freeze(Object.defineProperty({ __proto__: null, default: XR }, Symbol.toStringTag, { value: "Module" }));
const PJ = { __name: "gas", props: { form: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, list: { type: Array, default: () => [] }, basicClass: { type: Number, default: Ge.MATERIAL.V } }, setup(e, { expose: o }) {
  const n = e, c = Z(false), u = Z([]), r = Z({ resizable: true }), E = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: false, threshold: 80 }), V = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (P, L) => L.measureUnit && A(L.measurePrecision) ? !!P : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (P, L) => A(P) ? P > 0 : true, message: "核算量必须大于0", trigger: "blur" }] }, M = Ee(() => Object.assign({}, V)), g = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1]]), { tableValidate: S, cleanUpData: h, wrongCellMask: T } = ui({ rules: M, ditto: g });
  function _(P) {
    return P;
  }
  Ce(() => n.list, (P) => {
    A(n.list) ? u.value = JSON.parse(JSON.stringify(n.list)) : u.value = [], u.value.forEach((L) => {
      f(L);
    });
  }, { deep: true, immediate: true });
  function f(P) {
    Ce(() => P.mete, () => {
      m(P.mete, P);
    });
  }
  function m(P, L, O) {
    A(L.unitPrice) && A(P) ? L.amount = Be(P * L.unitPrice, Ze.YUAN) : L.amount = void 0, v(L, O || L);
  }
  function R(P, L, O) {
    if (u.value.splice(L, 1), A(u) && u.value.length > 0) {
      const x = u.value[0];
      u.value[0].projectId = x.projectId && x.projectId !== -1 ? x.projectId : void 0, u.value[0].workshopId = x.workshopId && x.workshopId !== -1 ? x.workshopId : void 0;
    }
  }
  function v(P, { accountingUnitNet: L, measurePrecision: O }) {
    !n.boolPartyA && P.measureUnit && L && (P.quantity = Be(P.mete * L, O));
  }
  function N() {
    if (Ae(u.value)) return ot.error("明细不能为空"), false;
    const P = u.value.filter((O, x) => (O.dataIndex = x, true)), { validResult: L } = S(P);
    return L && (h(P), P.forEach((O) => {
      var x, I;
      u.value[O.dataIndex].projectId = O.projectId, u.value[O.dataIndex].workshopId = O.workshopId || ((x = O.workshop) == null ? void 0 : x.id), u.value[O.dataIndex].warehouseId = O.warehouseId || ((I = O.warehouse) == null ? void 0 : I.id), u.value[O.dataIndex].quantity = O.measureUnit && A(O.measurePrecision) ? O.quantity : void 0;
    })), L;
  }
  return o({ rowInit: _, rowWatch: f, validate: N, tableList: u }), (P, L) => {
    const O = Ve("vxe-column"), x = Ve("vxe-tooltip"), I = Ve("common-input-number"), Y = Mt, ee = Ve("common-button"), B = Ve("vxe-table"), q = _t("empty-text"), ae = oi;
    return w(), Q("div", null, [qe((w(), Q("div", null, [(w(), U(B, { key: `import_${e.basicClass}`, "cell-class-name": l(T), "column-config": r.value, data: u.value, "empty-text": "暂无数据", "max-height": e.maxHeight, "scroll-y": E.value, border: "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(O, { title: "序号", type: "seq", width: "55" }), s(O, { align: "center", title: "申购单号", "min-width": "110px", field: "purchaseSN" }), s(O, { align: "center", title: "标识", "min-width": "110px", field: "uid" }), s(O, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: j }) => [s(x, { content: j.classifyParentFullName, disabled: !j.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[q, j.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(O, { align: "center", field: "specification", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: j }) => [s(x, { content: j.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(j.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(O, { align: "center", field: "measureUnit", "min-width": "100", title: "计量单位" }, { default: p(({ row: j }) => [C("span", null, K(j.measureUnit || "-"), 1)]), _: 1 }), s(O, { align: "center", field: "quantity", "min-width": "135px", title: "数量" }, { default: p(({ row: j }) => [l(A)(j.measureUnit) ? (w(), U(I, { key: 0, modelValue: j.quantity, "onUpdate:modelValue": (le) => j.quantity = le, controls: false, max: 999999999, min: 0, precision: j.measurePrecision, step: 1, placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : H("", true)]), _: 1 }), s(O, { align: "center", field: "accountingUnit", "min-width": "100", title: "核算单位" }, { default: p(({ row: j }) => [C("span", null, K(j.accountingUnit || "-"), 1)]), _: 1 }), s(O, { align: "center", field: "mete", "min-width": "120px", title: "核算量" }, { default: p(({ row: j }) => [s(I, { modelValue: j.mete, "onUpdate:modelValue": (le) => j.mete = le, controls: false, max: 999999999, min: 1e-6, precision: j.accountingPrecision, step: 1, placeholder: "核算量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), s(ts, { "weight-attribute": "mete" }), P.showColor ? (w(), U(O, { key: 0, align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: j }) => [s(Y, { modelValue: j.color, "onUpdate:modelValue": (le) => j.color = le, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : H("", true), s(O, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: j }) => [s(Y, { modelValue: j.brand, "onUpdate:modelValue": (le) => j.brand = le, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), e.form.orderPlace === l(Bt).FACTORY.V ? (w(), U(O, { key: 1, align: "center", field: "projectId", title: "所属项目", width: "140" }, { default: p(({ row: j, rowIndex: le }) => [s(l(ca), { modelValue: j.projectId, "onUpdate:modelValue": (oe) => j.projectId = oe, "show-extra": le !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra"])]), _: 1 })) : H("", true), e.form.orderPlace === l(Bt).FACTORY.V ? (w(), U(O, { key: 2, align: "center", field: "projectId", title: "仓库", width: "140" }, { default: p(({ row: j, rowIndex: le }) => [s(Ul, { modelValue: j.workshopId, "onUpdate:modelValue": (oe) => j.workshopId = oe, "show-extra": le !== 0, placeholder: "请选择仓库", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra"])]), _: 1 })) : H("", true), s(O, { align: "center", fixed: "right", title: "操作", width: "100" }, { default: p(({ row: j, rowIndex: le }) => [s(ee, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (oe) => R(j.sn, le, j) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y"]))])), [[ae, c.value]])]);
  };
} }, $R = ut(PJ, [["__scopeId", "data-v-cfa648b6"]]), OJ = Object.freeze(Object.defineProperty({ __proto__: null, default: $R }, Symbol.toStringTag, { value: "Module" }));
const kJ = { __name: "other", props: { form: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, list: { type: Array, default: () => [] }, basicClass: { type: Number, default: Ge.MATERIAL.V } }, setup(e, { expose: o }) {
  const n = e, c = Z(false), u = Z([]), r = Z({ resizable: true }), E = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: false, threshold: 80 }), V = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (P, L) => L.measureUnit && A(L.measurePrecision) ? !!P : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (P, L) => A(P) ? P > 0 : true, message: "核算量必须大于0", trigger: "blur" }] }, M = Ee(() => Object.assign({}, V)), g = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1]]), { tableValidate: S, cleanUpData: h, wrongCellMask: T } = ui({ rules: M, ditto: g });
  function _(P) {
    return P;
  }
  Ce(() => n.list, (P) => {
    A(n.list) ? u.value = JSON.parse(JSON.stringify(n.list)) : u.value = [], u.value.forEach((L) => {
      f(L);
    });
  }, { deep: true, immediate: true });
  function f(P) {
    Ce(() => P.mete, () => {
      m(P.mete, P);
    });
  }
  function m(P, L, O) {
    A(L.unitPrice) && A(P) ? L.amount = Be(P * L.unitPrice, Ze.YUAN) : L.amount = void 0, v(L, O || L);
  }
  function R(P, L, O) {
    if (u.value.splice(L, 1), A(u) && u.value.length > 0) {
      const x = u.value[0];
      u.value[0].projectId = x.projectId && x.projectId !== -1 ? x.projectId : void 0, u.value[0].workshopId = x.workshopId && x.workshopId !== -1 ? x.workshopId : void 0;
    }
  }
  function v(P, { accountingUnitNet: L, measurePrecision: O }) {
    !n.boolPartyA && P.measureUnit && L && (P.quantity = Be(P.mete * L, O));
  }
  function N() {
    if (Ae(u.value)) return ot.error("明细不能为空"), false;
    const P = u.value.filter((O, x) => (O.dataIndex = x, true)), { validResult: L } = S(P);
    return L && (h(P), P.forEach((O) => {
      var x, I;
      u.value[O.dataIndex].projectId = O.projectId, u.value[O.dataIndex].workshopId = O.workshopId || ((x = O.workshop) == null ? void 0 : x.id), u.value[O.dataIndex].warehouseId = O.warehouseId || ((I = O.warehouse) == null ? void 0 : I.id), u.value[O.dataIndex].quantity = O.measureUnit && A(O.measurePrecision) ? O.quantity : void 0;
    })), L;
  }
  return o({ rowInit: _, rowWatch: f, validate: N, tableList: u }), (P, L) => {
    const O = Ve("vxe-column"), x = Ve("vxe-tooltip"), I = Ve("common-input-number"), Y = Mt, ee = Ve("common-button"), B = Ve("vxe-table"), q = _t("empty-text"), ae = oi;
    return w(), Q("div", null, [qe((w(), Q("div", null, [(w(), U(B, { key: `import_${e.basicClass}`, "cell-class-name": l(T), "column-config": r.value, data: u.value, "empty-text": "暂无数据", "max-height": e.maxHeight, "scroll-y": E.value, border: "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(O, { title: "序号", type: "seq", width: "55" }), s(O, { align: "center", title: "申购单号", "min-width": "110px", field: "purchaseSN" }), s(O, { align: "center", title: "标识", "min-width": "110px", field: "uid" }), s(O, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: j }) => [s(x, { content: j.classifyParentFullName, disabled: !j.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[q, j.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(O, { align: "center", field: "specification", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: j }) => [s(x, { content: j.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(j.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(O, { align: "center", field: "measureUnit", "min-width": "100", title: "计量单位" }, { default: p(({ row: j }) => [C("span", null, K(j.measureUnit || "-"), 1)]), _: 1 }), s(O, { align: "center", field: "quantity", "min-width": "135px", title: "数量" }, { default: p(({ row: j }) => [l(A)(j.measureUnit) ? (w(), U(I, { key: 0, modelValue: j.quantity, "onUpdate:modelValue": (le) => j.quantity = le, controls: false, max: 999999999, min: 0, precision: j.measurePrecision, step: 1, placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : H("", true)]), _: 1 }), s(O, { align: "center", field: "accountingUnit", "min-width": "100", title: "核算单位" }, { default: p(({ row: j }) => [C("span", null, K(j.accountingUnit || "-"), 1)]), _: 1 }), s(O, { align: "center", field: "mete", "min-width": "120px", title: "核算量" }, { default: p(({ row: j }) => [s(I, { modelValue: j.mete, "onUpdate:modelValue": (le) => j.mete = le, controls: false, max: 999999999, min: 1e-6, precision: j.accountingPrecision, step: 1, placeholder: "核算量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), P.showColor ? (w(), U(O, { key: 0, align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: j }) => [s(Y, { modelValue: j.color, "onUpdate:modelValue": (le) => j.color = le, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : H("", true), s(ts, { "weight-attribute": "mete" }), s(O, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: j }) => [s(Y, { modelValue: j.brand, "onUpdate:modelValue": (le) => j.brand = le, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), e.form.orderPlace === l(Bt).FACTORY.V ? (w(), U(O, { key: 1, align: "center", field: "projectId", title: "所属项目", width: "140" }, { default: p(({ row: j, rowIndex: le }) => [s(l(ca), { modelValue: j.projectId, "onUpdate:modelValue": (oe) => j.projectId = oe, "show-extra": le !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra"])]), _: 1 })) : H("", true), e.form.orderPlace === l(Bt).FACTORY.V ? (w(), U(O, { key: 2, align: "center", field: "projectId", title: "仓库", width: "140" }, { default: p(({ row: j, rowIndex: le }) => [s(Ul, { modelValue: j.workshopId, "onUpdate:modelValue": (oe) => j.workshopId = oe, "show-extra": le !== 0, placeholder: "请选择仓库", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra"])]), _: 1 })) : H("", true), s(O, { align: "center", fixed: "right", title: "操作", width: "100" }, { default: p(({ row: j, rowIndex: le }) => [s(ee, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (oe) => R(j.sn, le, j) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y"]))])), [[ae, c.value]])]);
  };
} }, e3 = ut(kJ, [["__scopeId", "data-v-4995f30a"]]), DJ = Object.freeze(Object.defineProperty({ __proto__: null, default: e3 }, Symbol.toStringTag, { value: "Module" })), xJ = { class: "detail-import-inbound" }, t3 = { __name: "import-review-dialog", props: { modelValue: { type: Boolean, require: true }, basicClass: { type: Number }, list: { type: Array, default: () => [] }, form: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue", "apply"], setup(e, { emit: o }) {
  const n = o, c = e, { visible: u, handleClose: r } = Ta({ emit: n, props: c, showHook: V }), E = Z(), y = Z(false), { maxHeight: b } = Kt({ mainBox: ".detail-import-inbound", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false, minHeight: 300 }, u);
  function V() {
  }
  const M = Ee(() => {
    switch (c.basicClass) {
      case Pe.STEEL_PLATE.V:
        return GR;
      case Pe.SECTION_STEEL.V:
        return QR;
      case Pe.STEEL_COIL.V:
        return ZR;
      case Pe.OTHER_STEEL_MATERIALS.V:
        return JR;
      case Pe.MATERIAL.V:
        return XR;
      case Pe.GAS.V:
        return $R;
      case Pe.OTHER.V:
        return e3;
      default:
        return null;
    }
  });
  async function g(S) {
    var _;
    y.value = true;
    const h = (_ = E.value) == null ? void 0 : _.validate();
    let T = true;
    if (S === 1) {
      const f = E.value.tableList || [], m = [];
      f.forEach((v, N) => {
        m.findIndex((P) => P.uid === v.uid) < 0 && m.push({ uid: v.uid });
      });
      const R = [];
      if (m.forEach((v) => {
        var N;
        if (((N = f.filter((P) => P.uid === v.uid)) == null ? void 0 : N.length) > 1) {
          const P = "标识 " + v.uid + `
`;
          R.push({ errorMsg: P });
        }
      }), A(R)) {
        const v = R.map((N) => `<div>${N.errorMsg}<div>`).join("");
        ot({ message: v + "存在多条明细，覆盖导入情况下请确认并只保留一条信息", dangerouslyUseHTMLString: true, type: "error", duration: 5e3 }), T = false;
      }
    }
    h && T && (n("success", E.value.tableList, S), r()), y.value = false;
  }
  return (S, h) => {
    const T = Ve("common-button"), _ = Ve("common-dialog");
    return w(), U(_, { modelValue: l(u), "onUpdate:modelValue": h[2] || (h[2] = (f) => Gt(u) ? u.value = f : null), "before-close": l(r), "show-close": false, "close-on-click-modal": false, top: "5vh", width: "100%", "custom-class": "import-amount-error-fix-dialog", title: "物料明细批量导入" }, { titleRight: p(() => [s(T, { size: "default", type: "success", onClick: h[0] || (h[0] = (f) => g(1)), loading: y.value }, { default: p(() => h[3] || (h[3] = [Te("覆盖导入")])), _: 1, __: [3] }, 8, ["loading"]), s(T, { size: "default", type: "primary", onClick: h[1] || (h[1] = (f) => g(2)), loading: y.value }, { default: p(() => h[4] || (h[4] = [Te("增量导入")])), _: 1, __: [4] }, 8, ["loading"]), s(T, { size: "default", type: "warning", onClick: l(r), loading: y.value }, { default: p(() => h[5] || (h[5] = [Te("取消")])), _: 1, __: [5] }, 8, ["onClick", "loading"])]), default: p(() => [C("div", xJ, [(w(), U(Ri(M.value), { ref_key: "steelRef", ref: E, "max-height": l(b) - 220, form: e.form, basicClass: e.basicClass, list: c.list }, null, 8, ["max-height", "form", "basicClass", "list"]))])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, UJ = Object.freeze(Object.defineProperty({ __proto__: null, default: t3 }, Symbol.toStringTag, { value: "Module" })), i3 = { __name: "steel-plate-search", props: { query: { type: Object } }, emits: ["blur-query"], setup(e, { emit: o }) {
  const n = e, c = o, u = Z({ thickness: void 0, width: void 0, length: void 0 });
  Ce(() => n.query, () => {
    u.value.thickness = n.query.thickness, u.value.width = n.query.width, u.value.length = n.query.length;
  }, { deep: true });
  function r() {
    c("blur-query", u.value);
  }
  return (E, y) => {
    const b = Ve("common-input-number");
    return w(), Q(Qe, null, [s(b, { modelValue: u.value.thickness, "onUpdate:modelValue": y[0] || (y[0] = (V) => u.value.thickness = V), class: "filter-item", clearable: "", mode: "input", placeholder: "厚度", size: "default", style: { width: "100px" }, onBlur: r, onClear: r }, null, 8, ["modelValue"]), s(b, { modelValue: u.value.width, "onUpdate:modelValue": y[1] || (y[1] = (V) => u.value.width = V), class: "filter-item", clearable: "", mode: "input", placeholder: "宽度", size: "default", style: { width: "100px" }, onBlur: r, onClear: r }, null, 8, ["modelValue"]), s(b, { modelValue: u.value.length, "onUpdate:modelValue": y[2] || (y[2] = (V) => u.value.length = V), class: "filter-item", clearable: "", mode: "input", placeholder: "长度", size: "default", style: { width: "100px" }, onBlur: r, onClear: r }, null, 8, ["modelValue"])], 64);
  };
} }, YJ = Object.freeze(Object.defineProperty({ __proto__: null, default: i3 }, Symbol.toStringTag, { value: "Module" })), a3 = { __name: "section-steel-search", props: { query: { type: Object } }, emits: ["blur-query"], setup(e, { emit: o }) {
  const n = e, c = o, u = Z({ length: void 0 });
  Ce(() => n.query, () => {
    u.value.length = n.query.length;
  }, { deep: true });
  function r() {
    c("blur-query", u.value);
  }
  return (E, y) => {
    const b = Ve("common-input-number");
    return w(), U(b, { modelValue: u.value.length, "onUpdate:modelValue": y[0] || (y[0] = (V) => u.value.length = V), class: "filter-item", clearable: "", mode: "input", placeholder: "定尺长", size: "default", style: { width: "160px" }, onBlur: r, onClear: r }, null, 8, ["modelValue"]);
  };
} }, KJ = Object.freeze(Object.defineProperty({ __proto__: null, default: a3 }, Symbol.toStringTag, { value: "Module" })), l3 = { __name: "steel-coil-search", props: { query: { type: Object } }, emits: ["blur-query"], setup(e, { emit: o }) {
  const n = e, c = o, u = Z({ thickness: void 0, width: void 0, length: void 0, color: void 0 });
  Ce(() => n.query, () => {
    u.value.thickness = n.query.thickness, u.value.width = n.query.width, u.value.length = n.query.length, u.value.color = n.query.color;
  }, { deep: true });
  function r() {
    c("blur-query", u.value);
  }
  return (E, y) => {
    const b = Ve("common-input-number"), V = Mt;
    return w(), Q(Qe, null, [s(b, { modelValue: u.value.thickness, "onUpdate:modelValue": y[0] || (y[0] = (M) => u.value.thickness = M), class: "filter-item", clearable: "", mode: "input", placeholder: "厚度", size: "default", style: { width: "100px" }, onBlur: r, onClear: r }, null, 8, ["modelValue"]), s(b, { modelValue: u.value.width, "onUpdate:modelValue": y[1] || (y[1] = (M) => u.value.width = M), class: "filter-item", clearable: "", mode: "input", placeholder: "宽度", size: "default", style: { width: "100px" }, onBlur: r, onClear: r }, null, 8, ["modelValue"]), s(b, { modelValue: u.value.length, "onUpdate:modelValue": y[2] || (y[2] = (M) => u.value.length = M), class: "filter-item", clearable: "", mode: "input", placeholder: "长度", size: "default", style: { width: "100px" }, onBlur: r, onClear: r }, null, 8, ["modelValue"]), s(V, { modelValue: u.value.color, "onUpdate:modelValue": y[3] || (y[3] = (M) => u.value.color = M), class: "filter-item", clearable: "", placeholder: "可输入颜色搜索", size: "default", style: { width: "100px" }, onBlur: r, onClear: r }, null, 8, ["modelValue"])], 64);
  };
} }, WJ = Object.freeze(Object.defineProperty({ __proto__: null, default: l3 }, Symbol.toStringTag, { value: "Module" })), o3 = { __name: "other-search", props: { query: { type: Object } }, emits: ["blur-query"], setup(e, { emit: o }) {
  const n = e, c = o, u = Z({ color: void 0 });
  Ce(() => n.query, () => {
    u.value.color = n.query.color;
  }, { deep: true });
  function r() {
    c("blur-query", u.value);
  }
  return (E, y) => {
    const b = Mt;
    return w(), U(b, { modelValue: u.value.color, "onUpdate:modelValue": y[0] || (y[0] = (V) => u.value.color = V), class: "filter-item", clearable: "", placeholder: "可输入颜色搜索", size: "default", style: { width: "130px" }, onBlur: r, onClear: r }, null, 8, ["modelValue"]);
  };
} }, jJ = Object.freeze(Object.defineProperty({ __proto__: null, default: o3 }, Symbol.toStringTag, { value: "Module" }));
const FJ = { style: { "margin-right": "10px" } }, zJ = { __name: "index", props: { currentBasicClass: { type: Number }, showMaterial: { type: Boolean, default: true }, otherQuery: { type: Object, default: () => ({}) } }, emits: ["blur-query", "reset-query"], setup(e, { expose: o, emit: n }) {
  const c = n, u = e, r = Z(false), E = Ee(() => {
    switch (u.currentBasicClass) {
      case Pe.STEEL_PLATE.V:
        return i3;
      case Pe.SECTION_STEEL.V:
        return a3;
      case Pe.STEEL_COIL.V:
        return l3;
    }
    return o3;
  }), y = Z({ classifyId: [], brand: void 0, specification: void 0, thickness: void 0, width: void 0, length: void 0, color: void 0 });
  function b() {
    r.value = !r.value;
  }
  function V() {
    A(u.otherQuery) && (y.value = { ...y.value, ...u.otherQuery }), c("blur-query", y.value);
  }
  function M(S) {
    y.value.thickness = S.thickness, y.value.width = S.width, y.value.length = S.length, y.value.color = S.color, V();
  }
  async function g() {
    for (let S in y.value) y.value[S] = void 0;
    c("reset-query");
  }
  return Ce(() => u.currentBasicClass, () => {
    g();
  }, { deep: true }), o({ resetQuery: g, blurQuery: V }), (S, h) => {
    const T = Mt, _ = Fm;
    return w(), Q("div", { key: e.currentBasicClass, class: "search-index" }, [h[3] || (h[3] = C("div", { class: "text filter-item" }, "筛选项", -1)), qe(C("div", FJ, [!(u.currentBasicClass & l(ho)) && e.showMaterial ? (w(), U(Ql, { key: 0, modelValue: y.value.classifyId, "onUpdate:modelValue": h[0] || (h[0] = (f) => y.value.classifyId = f), "basic-class": u.currentBasicClass, "check-strictly": "", class: "filter-item", clearable: "", multiple: "", placeholder: "可选择/输入科目、编号搜索", separator: " > ", "show-all-levels": "", size: "default", style: { width: "230px" }, onChange: V }, null, 8, ["modelValue", "basic-class"])) : H("", true), xt(S.$slots, "AfterMaterial", {}, void 0, true), s(T, { modelValue: y.value.specification, "onUpdate:modelValue": h[1] || (h[1] = (f) => y.value.specification = f), class: "filter-item", clearable: "", placeholder: "可输入规格搜索", size: "default", style: { width: "160px" }, onBlur: V, onClear: V }, null, 8, ["modelValue"]), (w(), U(Ri(E.value), { query: y.value, onBlurQuery: M }, null, 40, ["query"])), s(T, { modelValue: y.value.brand, "onUpdate:modelValue": h[2] || (h[2] = (f) => y.value.brand = f), class: "filter-item", clearable: "", placeholder: "可输入品牌搜索", size: "default", style: { width: "160px" }, onChange: V, onClear: V }, null, 8, ["modelValue"])], 512), [[ln, !r.value]]), s(_, { underline: false, class: "filter-item", type: "primary", onClick: b }, { default: p(() => [Te(K(r.value ? "展开 >" : "< 收起"), 1)]), _: 1 })]);
  };
} }, bu = ut(zJ, [["__scopeId", "data-v-5f4fd454"]]), BJ = Object.freeze(Object.defineProperty({ __proto__: null, default: bu }, Symbol.toStringTag, { value: "Module" }));
const HJ = { class: "main-content" }, qJ = { class: "form-content" }, GJ = { class: "flex-rss child-mr-10" }, QJ = { class: "flex-rss child-mr-10" }, ZJ = { class: "flex-rss child-mr-10" }, JJ = { class: "form-right" }, XJ = { key: 0 }, $J = { key: 0, class: "right-head flex-rbs" }, eX = { class: "right-head-content", style: { display: "flex", "align-items": "center" } }, tX = { key: 0 }, iX = { class: "opt-content" }, aX = { class: "right-head flex-rbs" }, lX = { class: "right-head-content" }, oX = { key: 0, class: "label" }, nX = { key: 0 }, sX = { class: "opt-content" }, rX = { class: "table-remark" }, uX = { class: "con" }, cX = { class: "con" }, dX = { key: 1, style: { "font-size": "12px" } }, mX = { __name: "has-detail-form", props: { edit: { type: Boolean, default: false }, dialogVisible: { type: Boolean, default: false }, detail: { type: Object }, maxHeight: { type: Number, default: 100 }, isPassedEdit: { type: Boolean, default: false }, requisitionList: { type: Array, default: () => [] } }, emits: ["success", "materTypeToalChange"], setup(e, { expose: o, emit: n }) {
  const c = Ht(), u = n, r = ft("supplyUsedProject"), E = ft("projectAllType");
  Z({});
  const y = ft("priceAbnormal"), b = { purchaseType: Fi.RAW_MATERIAL.V, boolTemporaryStorage: false, boolDetail: true, isGoForOaApproval: true, attachmentIds: void 0, orderPlace: void 0, list: [], sectionSteelList: [], steelPlateList: [], steelCoilList: [], auxiliaryMaterialList: [], otherList: [], gasList: [], originSteelPlateList: [], originSteelCoilList: [], otherSteelMaterialList: [], originSectionSteelList: [], originOtherSteelMaterialList: [], originAuxMatList: [], originGasList: [], originOtherList: [], requisitions: [], requisitionsKV: {}, actualRequisitionIds: [], structureList: [], enclosureList: [], artifactWageQuotaType: ha.WEIGHT.V, enclosureWageQuotaType: ga.LENGTH.V, materialTypeTotal: [], isFirst: false }, V = e, M = Z(false), g = Z(), S = Z(), h = Z(false), T = Z(), _ = Z(false), { cu: f, form: m, FORM: R } = Pa({ title: "采购合同", formStore: !V.edit, formStoreKey: "SUPPLY_CHAIN_PURCHASE_ORDER", defaultForm: b, useDraftCallback: N, clearDraftCallback: P, api: V.edit ? Pc : x1 }, g, V.detail);
  Ce(() => V.detail, (it = {}) => {
    var tt, Vt, Nt, Rt;
    m.useRequisitions = it.useRequisitions, m.materialType = V.detail.purchaseType === Fi.MANUFACTURED.V ? V.detail.currentMaterial : V.detail.materialType, m.purchaseType = V.detail.purchaseType, m.currentBasicClass = V.detail.currentBasicClass, m.supplyType = V.detail.supplyType, m.boolUsed = V.detail.boolUsed, m.projectId = V.detail.projectId, m.branchCompanyId = V.detail.branchCompanyId || ((Vt = (tt = V.detail) == null ? void 0 : tt.branchCompany) == null ? void 0 : Vt.id), m.actualRequisitionIds = V.detail.purchaseType === Fi.MANUFACTURED.V ? V.detail.actualRequisitionIds : [], m.isGoForOaApproval = (Nt = V.detail) == null ? void 0 : Nt.isGoForOaApproval, m.requisitions = [], (Rt = m.applyPurchase) == null || Rt.forEach((Pt) => {
      Pt.id && m.requisitions.push(Pt);
    });
  }, { deep: true, immediate: true }), yi("cu", f);
  const v = Ee(() => m.purchaseType);
  function N() {
  }
  function P() {
  }
  const L = (it, tt, Vt) => {
    m.invoiceType ? (m.invoiceType === fi.SPECIAL.V || m.invoiceType === fi.ORDINARY.V) && Ae(m.taxRate) ? Vt(new Error("请选择税率")) : Vt() : Vt(new Error("请选择"));
  }, O = { serialNumber: [{ max: 30, message: "订单编号长度不可超过30位", trigger: "blur" }], materialTypeTotal: [{ required: true, message: "请选择", trigger: "change" }], projectId: [{ required: true, message: "请选择", trigger: "change" }], workshopId: [{ required: true, message: "请选择", trigger: "change" }], supplyType: [{ required: true, message: "请选择", trigger: "change" }], supplierId: [{ required: true, message: "请选择", trigger: "change" }], orderPlace: [{ required: true, message: "请选择", trigger: "change" }], branchCompanyId: [{ required: true, message: "请选择", trigger: "change" }], weightMeasurementMode: [{ required: true, message: "请选择", trigger: "change" }], projectAttribute: [{ required: true, message: "请选择", trigger: "change" }], actualRequisitionIds: [{ required: true, message: "请选择", trigger: "change" }] }, x = { supplierId: [{ required: true, message: "请选择", trigger: "change" }] }, I = { logisticsTransportType: [{ required: true, message: "请选择", trigger: "change" }], logisticsPayerType: [{ required: true, message: "请选择", trigger: "change" }], purchaseOrderPaymentMode: [{ required: true, message: "请选择", trigger: "change" }], invoiceType: [{ required: true, validator: L, trigger: "change" }], taxRate: [{ max: 2, message: "请输入税率", trigger: "blur" }], mete: [{ required: true, message: "请填写合同量", trigger: "blur" }], amount: [{ required: true, message: "请填写合同额", trigger: "blur" }] }, ee = { auxMaterialIds: [{ required: true, validator: (it, tt, Vt) => {
    m.isAllMaterial || tt ? Vt() : Vt(new Error("请选择辅材"));
  }, trigger: "change" }] }, q = { otherMaterialIds: [{ required: true, validator: (it, tt, Vt) => {
    m.isAllOtherMaterial || tt ? Vt() : Vt(new Error("请选择办公用品科目"));
  }, trigger: "change" }] }, ae = Ee(() => {
    const it = {};
    return Object.assign(it, O), Object.assign(it, O), Object.assign(it, I), m.materialType & ct.MATERIAL.V && !m.useRequisitions && Object.assign(it, ee), m.materialType & ct.OTHER.V && !m.useRequisitions && Object.assign(it, q), m.boolTemporaryStorage ? x : it;
  });
  Dt(() => {
    V.dialogVisible && pt(() => {
      A(V.requisitionList) && m.purchaseType === Fi.MANUFACTURED.V && (m.actualRequisitionIds = V.requisitionList.map((it) => it.id), m.requisitions = [], V.requisitionList.forEach((it) => {
        m.requisitions.push({ id: it.id, serialNumber: it.serialNumber });
      })), g.value && g.value.clearValidate();
    });
  });
  const j = Ee(() => !!(m.materialType & ct.MANUFACTURED.V)), le = Z([]), oe = Z([]);
  Ce(() => m.materialTypeTotal, (it, tt) => {
    var Vt;
    if (m.materialType = m.materialType || void 0, m.currentBasicClass = m.currentBasicClass || void 0, m.currentMaterial = m.currentMaterial || void 0, le.value = [], A(m.materialTypeTotal)) if (m.materialTypeTotal.includes(ct.STEEL.V)) le.value = [Pe.STEEL_PLATE, Pe.SECTION_STEEL, Pe.STEEL_COIL, Pe.OTHER_STEEL_MATERIALS], m.isFirst ? m.currentBasicClass = A(m.steelPlateList) ? Pe.STEEL_PLATE.V : A(m.sectionSteelList) ? Pe.SECTION_STEEL.V : Pe.STEEL_COIL.V : m.currentBasicClass = Pe.STEEL_PLATE.V, m.currentBasicClass = Pe.STEEL_PLATE.V, m.currentMaterial = ct.STEEL.V, m.materialType = ct.STEEL.V, m.purchaseType = Fi.RAW_MATERIAL.V;
    else if (m.materialTypeTotal.includes(ct.MANUFACTURED.V)) m.materialType = ct.MANUFACTURED.V, le.value = [Pe.STRUC_MANUFACTURED, Pe.ENCL_MANUFACTURED], m.currentMaterial = ct.MANUFACTURED.V, m.currentBasicClass = Pe.STRUC_MANUFACTURED.V, m.purchaseType = Fi.MANUFACTURED.V;
    else {
      for (let Nt = 0; Nt < m.materialTypeTotal.length; Nt++) m.materialType = Nt === 0 ? m.materialTypeTotal[0] : m.materialType | m.materialTypeTotal[Nt], le.value.push(Pe.V[m.materialTypeTotal[Nt]]);
      m.materialTypeTotal.includes(ct.MATERIAL.V) ? (m.currentMaterial = ct.MATERIAL.V, m.currentBasicClass = Pe.MATERIAL.V) : m.materialTypeTotal.includes(ct.OTHER.V) ? (m.currentMaterial = ct.OTHER.V, m.currentBasicClass = Pe.OTHER.V) : (m.currentMaterial = ct.GAS.V, m.currentBasicClass = Pe.GAS.V), m.purchaseType = Fi.RAW_MATERIAL.V;
    }
    if (m.basicClass = m.materialType, z.value, Ae(it) && (it = []), Ae(tt) && (tt = []), oe.value = tt, tt.length - it.length === 1 && it.length !== 0 && V.dialogVisible) {
      let Nt;
      tt.forEach((Rt) => {
        it.includes(Rt) || (Nt = Rt);
      }), (Nt & Xs.STEEL.V && m.steelPlateList.length + m.sectionSteelList.length + m.steelCoilList.length + m.otherSteelMaterialList.length > 0 || !(Nt & Xs.STEEL.V) && ((Vt = m[Ci.V[Nt].LIST]) != null && Vt.length)) && zi.confirm("该材料类型下已添加采购明细，如取消，采购明细将自动清空。请确认?", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }).then(() => {
        V.edit ? (m.isFirst && he(Nt), m.isFirst = false) : (m.isFirst || he(Nt), m.isFirst = false), console.log(m.isFirst), m.isFirst || he(Nt), m.isFirst = false;
      }).catch(() => {
        m.materialTypeTotal = tt;
      });
    } else (tt.length - it.length >= 1 || it.length === 0 && tt.length > 0) && V.dialogVisible;
  });
  const ye = Ee(() => {
    switch (m.materialType) {
      case ct.STEEL.V:
        return kR;
      case ct.MANUFACTURED.V:
        return NR;
      default:
        return YR;
    }
  }), ce = Ee(() => m.list.findIndex((it) => it.isRequisition) > -1), se = Z();
  function he(it) {
    it & ct.STEEL.V ? ge() : (it & ct.GAS.V && (m.gasList = [], m.originGasList = []), it & ct.MATERIAL.V && (m.auxiliaryMaterialList = [], m.originAuxMatList = []), it & ct.OTHER.V && (m.otherList = [], m.originOtherList = []), A(it) && be(it)), m.list = [], m.requisitionsKV = {}, m.actualRequisitionIds = [], m.structureList = [], m.enclosureList = [], m.manufListObj = {};
  }
  function be(it) {
    z.value && z.value.clearByBasicClass(it);
  }
  function me() {
  }
  const ge = () => {
    m.list = [], m.sectionSteelList = [], m.steelPlateList = [], m.steelCoilList = [], m.auxiliaryMaterialList = [], m.otherSteelMaterialList = [], m.otherList = [], m.gasList = [], m.requisitionsKV = {}, m.actualRequisitionIds = [], m.structureList = [], m.enclosureList = [], m.manufListObj = {}, m.originSteelPlateList = [], m.originSteelCoilList = [], m.otherSteelMaterialList = [], m.originSectionSteelList = [], m.originOtherSteelMaterialList = [], m.originAuxMatList = [], m.originGasList = [], m.originOtherList = [], z.value && z.value.clear();
  }, Le = { [Pe.STEEL_PLATE.V]: "steelPlateList", [Pe.SECTION_STEEL.V]: "sectionSteelList", [Pe.STEEL_COIL.V]: "steelCoilList", [Pe.OTHER_STEEL_MATERIALS.V]: "otherSteelMaterialList", [Pe.MATERIAL.V]: "auxiliaryMaterialList", [Pe.OTHER.V]: "otherList", [Pe.GAS.V]: "gasList", [Pe.STRUC_MANUFACTURED.V]: "structureList", [Pe.ENCL_MANUFACTURED.V]: "enclosureList" }, Ie = { [Pe.STEEL_PLATE.V]: "originSteelPlateList", [Pe.SECTION_STEEL.V]: "originSectionSteelList", [Pe.STEEL_COIL.V]: "originSteelCoilList", [Pe.OTHER_STEEL_MATERIALS.V]: "originOtherSteelMaterialList", [Pe.MATERIAL.V]: "originAuxMatList", [Pe.OTHER.V]: "originOtherList", [Pe.GAS.V]: "originGasList" }, Se = Ee(() => {
    switch (m.currentBasicClass) {
      case Pe.STEEL_PLATE.V:
        return NQ;
      case Pe.SECTION_STEEL.V:
        return LQ;
      case Pe.STEEL_COIL.V:
        return IQ;
      case Pe.OTHER_STEEL_MATERIALS.V:
        return CQ;
      case Pe.MATERIAL.V:
        return PQ;
      case Pe.GAS.V:
        return kQ;
      default:
        return OQ;
    }
  }), X = Ee(() => {
    switch (m.currentBasicClass) {
      case Pe.STEEL_PLATE.V:
        return _R;
      case Pe.SECTION_STEEL.V:
        return bR;
      case Pe.STEEL_COIL.V:
        return VR;
      case Pe.OTHER_STEEL_MATERIALS.V:
        return wR;
      case Pe.MATERIAL.V:
        return SR;
      case Pe.GAS.V:
        return RR;
      default:
        return vR;
    }
  }), $ = Ee(() => {
    let it = [];
    switch (m.currentBasicClass) {
      case Pe.STEEL_PLATE.V:
        it = m.steelPlateList;
        break;
      case Pe.SECTION_STEEL.V:
        it = m.sectionSteelList;
        break;
      case Pe.STEEL_COIL.V:
        it = m.steelCoilList;
        break;
      case Pe.OTHER_STEEL_MATERIALS.V:
        it = m.otherSteelMaterialList;
        break;
      case Pe.MATERIAL.V:
        it = m.auxiliaryMaterialList;
        break;
      case Pe.OTHER.V:
        it = m.otherList;
        break;
      case Pe.GAS.V:
        it = m.gasList;
        break;
      default:
        it = [];
        break;
    }
    const tt = JSON.parse(JSON.stringify(it));
    return tt == null || tt.forEach((Vt) => {
      (m.currentBasicClass === Pe.STEEL_PLATE.V || m.currentBasicClass === Pe.SECTION_STEEL.V) && (Vt.weightMeasurementModeName = Wt.VL[Vt.weightMeasurementMode]), Vt.classifyName = Vt.classifyFullName.split(" > ").join("/"), Vt.project = Vt.projectId ? E.value.find((Nt) => Nt.id === Vt.projectId) || {} : {}, Vt.shortName = Vt.project ? Vt.project.shortName : void 0;
    }), { title: "", filename: Pe.VL[m.currentBasicClass] + "当前明细下载", header: null, footer: null, table: tt, qrCode: null };
  }), k = Ee(() => {
    switch (m.currentBasicClass) {
      case Pe.STEEL_PLATE.V:
        return pR;
      case Pe.SECTION_STEEL.V:
        return hR;
      case Pe.STEEL_COIL.V:
        return fR;
      case Pe.OTHER_STEEL_MATERIALS.V:
        return gR;
      case Pe.MATERIAL.V:
        return ER;
      case Pe.GAS.V:
        return TR;
      default:
        return yR;
    }
  }), J = Z(), z = Z(), F = Z(false);
  Z(false);
  const G = Z(false), ie = Z([]), ue = Z([]), ne = Z([]), te = Z(false), de = Z([]), pe = Z(false), re = Ee(() => {
    var tt, Vt;
    const it = (tt = f == null ? void 0 : f.submitResult) == null ? void 0 : tt.data;
    return Array.isArray(it) ? (Vt = m.list) == null ? void 0 : Vt.filter((Nt) => it.includes(Nt.classifyId)) : [];
  });
  yi("matSpecRef", z);
  const { maxHeight: we } = Kt({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => {
    var it;
    return (it = J.value) == null ? void 0 : it.loaded;
  });
  Ce(() => m.needFirstWatch, (it) => {
    it && pt(() => {
      var tt;
      (tt = se.value) == null || tt.setFormCallback(m);
    });
  }, { immediate: true });
  function Ke() {
    se.value.deleteTableData();
  }
  function Me(it) {
    m.branchCompany = it, m.orderPlace = it.level || Bt.FACTORY.V, m.level = it.level, Je(m.orderPlace);
  }
  function Ne(it) {
    m.projectId = void 0, m.useRequisitions && A(m.actualRequisitionIds) && ge(), m.requisitionsKV = {}, m.requisitions = [], m.actualRequisitionIds = [], Oe();
  }
  function He(it) {
    var tt;
    ge(), m.projectId = void 0, m.requisitionsKV = {}, m.requisitions = [], m.actualRequisitionIds = [], m.useRequisitions = ea.TRUE.V, it === Fi.MANUFACTURED.V && (m.boolAnnual = Vn.NOT_YEAR.V), m.orderPlace = ((tt = m.branchCompany) == null ? void 0 : tt.level) || Bt.FACTORY.V;
  }
  function ze() {
    var it, tt, Vt;
    if (m.requisitions = [], m.requisitionsKV = {}, A(m.actualRequisitionIds)) {
      for (let Pt = 0; Pt < m.actualRequisitionIds.length; Pt++) {
        const _i = ((it = ne.value) == null ? void 0 : it.find((Yt) => Yt.id === m.actualRequisitionIds[Pt])) || {};
        A(_i) && (m.requisitions.push({ id: m.actualRequisitionIds[Pt], serialNumber: _i == null ? void 0 : _i.serialNumber }), m.requisitionsKV[m.actualRequisitionIds[Pt]] = _i == null ? void 0 : _i.serialNumber);
      }
      const Nt = [];
      (tt = m.structureList) == null || tt.forEach((Pt, _i) => {
        var ni, Ia;
        const Yt = [];
        (ni = Pt.list) == null || ni.forEach((la, Yl) => {
          m.actualRequisitionIds.includes(la.applyPurchaseId) || Yt.push(Yl);
        });
        for (let la = 0; la < Yt.length; la++) Pt.list.splice(Yt[la], 1);
        ((Ia = Pt == null ? void 0 : Pt.list) == null ? void 0 : Ia.length) > 0 ? (Pt.quantity = 0, Pt.totalWeight = 0, Pt.totalLength = 0, Pt.totalArea = 0, Pt.list.forEach((la) => {
          Pt.quantity += la.quantity || 0, Pt.totalWeight += la.totalWeight || 0, Pt.totalLength += la.totalLength || 0, Pt.totalArea += la.totalArea || 0;
        })) : Nt.push(_i);
      });
      for (let Pt = 0; Pt < Nt.length; Pt++) m.structureList.splice(Nt[Pt], 1);
      const Rt = [];
      (Vt = m.enclosureList) == null || Vt.forEach((Pt, _i) => {
        var ni, Ia;
        const Yt = [];
        (ni = Pt.list) == null || ni.forEach((la, Yl) => {
          m.actualRequisitionIds.includes(la.applyPurchaseId) || Yt.push(la.applyPurchaseDetailId);
        });
        for (let la = 0; la < Yt.length; la++) Pt.list.splice(Yt[la], 1);
        ((Ia = Pt == null ? void 0 : Pt.list) == null ? void 0 : Ia.length) > 0 ? (Pt.quantity = 0, Pt.totalWeight = 0, Pt.totalLength = 0, Pt.totalArea = 0, Pt.list.forEach((la) => {
          Pt.quantity += la.quantity || 0, Pt.totalWeight += la.totalWeight || 0, Pt.totalLength += la.totalLength || 0, Pt.totalArea += la.totalArea || 0;
        })) : Rt.push(_i);
      });
      for (let Pt = 0; Pt < Rt.length; Pt++) m.enclosureList.splice(Rt[Pt], 1);
    } else m.structureList = [], m.enclosureList = [];
  }
  async function Oe() {
    try {
      if (!m.branchCompanyId || !m.projectId || m.purchaseType !== Fi.MANUFACTURED.V || !m.currentBasicClass) return;
      ne.value = [];
      const it = await KU({ materialType: ct.MANUFACTURED.V, branchCompanyId: m.branchCompanyId, projectId: m.projectId });
      ne.value = it.filter((tt) => !V.edit && tt.purchaseCreationState !== Yo.COMPLETED.V || V.edit);
    } catch (it) {
      console.log(it, "获取申购单列表失败");
    }
  }
  function Re(it) {
    if (it === "artifact") {
      switch (m.artifactWageQuotaType) {
        case ha.WEIGHT.V:
          m.artifactUnit = "吨";
          break;
        case ha.LENGTH.V:
          m.artifactUnit = "米";
          break;
        case ha.QUANTITY.V:
          m.artifactUnit = "件";
          break;
      }
      m.structureList.forEach((tt) => {
        tt.wageQuotaType = m.artifactWageQuotaType, tt.list.forEach((Vt) => {
          Vt.wageQuotaType = m.artifactWageQuotaType;
        });
      });
    } else {
      switch (m.artifactWageQuotaType) {
        case ga.LENGTH.V:
          m.enclosureUnit = "米";
          break;
        case ga.AREA.V:
          m.enclosureUnit = "平方米";
          break;
        case ga.QUANTITY.V:
          m.enclosureUnit = "张";
          break;
      }
      m.enclosureList.forEach((tt) => {
        tt.wageQuotaType = m.enclosureWageQuotaType, tt.list.forEach((Vt) => {
          Vt.wageQuotaType = m.artifactWageQuotaType;
        });
      });
    }
  }
  async function fe(it) {
    var tt;
    if (it) if (m.purchaseType === Fi.MANUFACTURED.V) await Oe();
    else {
      const Vt = [];
      (tt = m.originList) == null || tt.forEach((Rt) => {
        (Rt.projectId === it || !Rt.projectId || Rt.projectId === -1) && Vt.push(Rt);
      });
      const Nt = ["steelPlateList", "steelCoilList", "sectionSteelList", "otherSteelMaterialList", "auxiliaryMaterialList", "otherList", "gasList"];
      for (let Rt = 0; Rt < Nt.length; Rt++) JSON.parse(JSON.stringify(m[Nt[Rt]])).forEach((_i) => {
        (!_i.projectId || _i.projectId === it || _i.projectId === -1) && Vt.findIndex((Yt) => Yt.uid === _i.uid) < 0 && Vt.push(_i);
      });
      m.steelPlateList = [], m.sectionSteelList = [], m.steelCoilList = [], m.otherSteelMaterialList = [], m.auxiliaryMaterialList = [], m.otherList = [], m.gasList = [], m.list = Vt, Vt.forEach((Rt) => {
        switch (Rt.basicClass) {
          case Pe.STEEL_PLATE.V:
            m.steelPlateList.push(Rt);
            break;
          case Pe.SECTION_STEEL.V:
            m.sectionSteelList.push(Rt);
            break;
          case Pe.STEEL_COIL.V:
            m.steelCoilList.push(Rt);
            break;
          case Pe.OTHER_STEEL_MATERIALS.V:
            m.otherSteelMaterialList.push(Rt);
            break;
          case Pe.MATERIAL.V:
            m.auxiliaryMaterialList.push(Rt);
            break;
          case Pe.GAS.V:
            m.gasList.push(Rt);
            break;
          case Pe.OTHER.V:
            m.otherList.push(Rt);
            break;
        }
      }), pt(() => {
        var Rt;
        (Rt = se.value) == null || Rt.setFormCallback(m);
      });
    }
  }
  function Ue(it) {
    m.projects = [it];
  }
  function Je(it) {
    if (!Ae(it) && m.purchaseType === Fi.RAW_MATERIAL.V && m.level === Bt.CONSTRUCTION_SITE.V) {
      const tt = it === Bt.CONSTRUCTION_SITE.V ? "您选择是直发工地，接收部门将为项目部" : "您选择是直发工厂，接收单位为仓库部门";
      zi.confirm(tt, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }).then(() => {
      }).catch(() => {
        m.orderPlace = void 0;
      });
    }
  }
  function Xe() {
    m.boolSysgen && (Ii.value.supplierId === m.supplierId ? m.serialNumber = Ii.value.serialNumber : m.serialNumber = void 0);
  }
  function Ye(it) {
    let tt = [];
    A(it == null ? void 0 : it.basicClass) && (tt = Ra.getBits(Pe.ENUM, it.basicClass, "V"));
    const Vt = [];
    for (let Pt = 0; Pt < tt.length; Pt++) Vt.push({ V: tt[Pt] });
    const Nt = [], Rt = [];
    for (const Pt in ct.ENUM) Vt.findIndex((_i) => _i.V & ct.ENUM[Pt].V) < 0 ? Nt.findIndex((_i) => _i.V === ct.ENUM[Pt].V) < 0 && (Nt.push(ct.ENUM[Pt]), Rt.push(ct.ENUM[Pt].V)) : ue.value.push(ct.ENUM[Pt].V);
    ie.value = m.id ? Rt : [], m.annualContractId = it == null ? void 0 : it.annualContractId;
  }
  function Fe(it) {
    return m.orderPlace === Bt.CONSTRUCTION_SITE.V && m.projectId && (it.projectId = m.projectId), se.value.rowInit(it);
  }
  function et(it) {
    var _i;
    const tt = [], Vt = {};
    it.forEach((Yt, ni) => {
      Yt.index = ni + 1, tt.includes(Yt.uid) || (tt.push(Yt.uid), Vt[Yt.uid] = []);
    });
    let Nt = [];
    switch (m.currentBasicClass) {
      case Pe.STEEL_PLATE.V:
        Nt = m.steelPlateList;
        break;
      case Pe.SECTION_STEEL.V:
        Nt = m.sectionSteelList;
        break;
      case Pe.STEEL_COIL.V:
        Nt = m.steelCoilList;
        break;
      case Pe.OTHER_STEEL_MATERIALS.V:
        Nt = m.otherSteelMaterialList;
        break;
      case Pe.MATERIAL.V:
        Nt = m.auxiliaryMaterialList;
        break;
      case Pe.OTHER.V:
        Nt = m.otherList;
        break;
      case Pe.GAS.V:
        Nt = m.gasList;
        break;
      default:
        Nt = [];
        break;
    }
    const Rt = [], Pt = [];
    for (let Yt = 0; Yt < tt.length; Yt++) if (Nt.findIndex((ni) => ni.uid === tt[Yt]) > -1) {
      const ni = it.filter((la) => la.uid === tt[Yt]), Ia = Nt.find((la) => la.uid === tt[Yt]) || {};
      if (A(ni)) {
        const la = [];
        ni.forEach((Yl, Or) => {
          if (Ia.classifyId === Yl.classifyId && (!Ia.specification || Ia.specification === Yl.specification)) la.push({ originData: Ia, ...Yl });
          else {
            const Bs = [];
            Ia.classifyId !== Yl.classifyId && Bs.push("物料种类" + Yl.classifyName), Ia.specification && Ia.specification !== Yl.specification && Bs.push("规格" + Yl.specification), Yl.errorMsg = Bs.join("、"), Pt.push(Yl);
          }
        }), Vt[tt[Yt]] = la;
      }
    } else Rt.push(tt[Yt]);
    if (A(Rt)) {
      ot.error(`不存在${Rt.map((Yt) => `“${Yt}”`).join("、")}${Rt.length > 1 ? "等" : ""}标识`);
      return;
    }
    if (A(Pt)) {
      const Yt = [];
      Pt.forEach((Ia) => {
        const la = "序号" + Ia.index + "标识" + Ia.uid + " " + Ia.errorMsg + ` 有误
`;
        Yt.push({ errorMsg: la });
      });
      const ni = Yt.map((Ia) => `<div>${Ia.errorMsg}<div>`).join("");
      ot({ message: ni, dangerouslyUseHTMLString: true, type: "error", duration: 5e3 });
      return;
    }
    de.value = [];
    for (const Yt in Vt) (_i = Vt[Yt]) == null || _i.forEach((ni) => {
      de.value.push(ni);
    });
    de.value.forEach((Yt) => {
      Yt.quantity || (Yt.quantity = void 0);
    }), de.value.map((Yt, ni) => {
      Yt.projectId = Yt.projectId || (ni > 0 ? -1 : void 0), Yt.workshopId = Yt.workshopId || (ni > 0 ? -1 : void 0);
    }), pe.value = true;
  }
  function lt(it, tt) {
    let Vt = [];
    switch (m.currentBasicClass) {
      case Pe.STEEL_PLATE.V:
        Vt = m.steelPlateList;
        break;
      case Pe.SECTION_STEEL.V:
        Vt = m.sectionSteelList;
        break;
      case Pe.STEEL_COIL.V:
        Vt = m.steelCoilList;
        break;
      case Pe.OTHER_STEEL_MATERIALS.V:
        Vt = m.otherSteelMaterialList;
        break;
      case Pe.MATERIAL.V:
        Vt = m.auxiliaryMaterialList;
        break;
      case Pe.OTHER.V:
        Vt = m.otherList;
        break;
      case Pe.GAS.V:
        Vt = m.gasList;
        break;
      default:
        Vt = [];
        break;
    }
    const Nt = [];
    if (it.forEach((Rt) => {
      var _i;
      let Pt = Vt.find((Yt) => Yt.uid === Rt.uid);
      if (m.orderPlace === Bt.CONSTRUCTION_SITE.V && m.projectId && (Rt.projectId = m.projectId), A(Pt)) {
        const Yt = Ct({ ...Pt, ...Rt }), ni = [];
        if (tt === 1 ? (Pt = Yt, Nt.push(Pt)) : (Yt.purchaseSN || ni.push({ sn: Yt.sn, classifyId: Yt.classifyId }), Yt.uid = Tt(), m[Ie[Yt.basicClass]].push(Yt), Vt.push(Yt)), tt === 2 && A(ni)) {
          const Ia = Ce(z, () => {
            z.value && (z.value.initSelected(ni), pt(() => {
              Ia();
            }));
          }, { immediate: true });
        }
        (_i = se.value) == null || _i.rowWatch(Yt);
      }
    }), tt === 1) {
      switch (m.currentBasicClass) {
        case Pe.STEEL_PLATE.V:
          m.steelPlateList = Nt;
          break;
        case Pe.SECTION_STEEL.V:
          m.sectionSteelList = Nt;
          break;
        case Pe.STEEL_COIL.V:
          m.steelCoilList = Nt;
          break;
        case Pe.OTHER_STEEL_MATERIALS.V:
          m.otherSteelMaterialList = Nt;
          break;
        case Pe.MATERIAL.V:
          m.auxiliaryMaterialList = Nt;
          break;
        case Pe.OTHER.V:
          m.otherList = Nt;
          break;
        case Pe.GAS.V:
          m.gasList = Nt;
          break;
        default:
          Vt = [];
          break;
      }
      m[Ie[m.currentBasicClass]] = Nt;
    }
  }
  function bt() {
    var it, tt, Vt;
    if (A(re.value) && A((it = f == null ? void 0 : f.submitResult) == null ? void 0 : it.data)) {
      ot.error("请删除全部标红数据");
      return;
    }
    if (m.materialType & ct.MATERIAL.V && !m.isAllMaterial && !((tt = m.auxMaterialIds) != null && tt.length) && !m.useRequisitions) {
      ot.warning("请先选择辅材明细");
      return;
    }
    if (m.materialType & ct.OTHER.V && !m.isAllOtherMaterial && !((Vt = m.otherMaterialIds) != null && Vt.length) && !m.useRequisitions) {
      ot.warning("请先选择办公用品明细");
      return;
    }
    F.value = true;
  }
  function gt(it) {
    var tt, Vt, Nt;
    m.materialType & ct.STEEL.V && it.forEach((Rt) => {
      m.orderPlace === Bt.CONSTRUCTION_SITE.V && m.projectId && (Rt.projectId = m.projectId), Rt.weightMeasurementMode = m.weightMeasurementMode;
    }), (tt = f == null ? void 0 : f.submitResult) != null && tt.data && (f.submitResult.data = null);
    try {
      const Rt = Le[m.currentBasicClass], Pt = m[Rt].length;
      m[Rt].push.apply(m[Rt], it);
      const _i = m[Rt].length;
      if ((Vt = se.value) != null && Vt.rowWatch) for (let ni = Pt; ni < _i; ni++) (Nt = se.value) == null || Nt.rowWatch(m[Rt][ni]), m[Ie[m[Rt][ni].basicClass]].push(m[Rt][ni]);
      const Yt = Ce(z, () => {
        z.value && (z.value.initSelected(it.map((ni) => ({ sn: ni.sn, classifyId: ni.classifyId }))), pt(() => {
          Yt();
        }));
      }, { immediate: true });
    } catch (Rt) {
      ot.error({ message: Rt.message, duration: 5e3 });
    }
  }
  const qt = Z(), kt = Z(false), Ii = Z({});
  Dt(() => {
    var it;
    if (m.purchaseType === Fi.RAW_MATERIAL.V) {
      m.requisitions = Ps(m.requisitionsKV);
      const tt = ["steelPlateList", "steelCoilList", "sectionSteelList", "otherSteelMaterialList"], Vt = ["auxiliaryMaterialList", "otherList", "gasList"], Nt = m.materialType & ct.STEEL.V ? tt : Vt, Rt = [];
      if (A(Nt)) for (let Pt = 0; Pt < Nt.length; Pt++) {
        const _i = [];
        (it = m[Nt[Pt]]) == null || it.forEach((Yt) => {
          Yt.applyPurchaseId ? m.requisitions.findIndex((ni) => ni.id === Yt.applyPurchaseId) > -1 && (Rt.push(Yt.applyPurchaseId), A(m.requisitionsKV) && A(m.requisitionsKV[Yt.applyPurchaseId]), _i.push(Yt)) : _i.push(Yt);
        }), m[Nt[Pt]] = _i;
      }
      m.actualRequisitionIds = Tn(Rt);
    }
  });
  function ra() {
    if (!m.branchCompanyId) {
      ot.warning("请先选择采购单位");
      return;
    }
    if (m.orderPlace === Bt.CONSTRUCTION_SITE.V && !m.projectId) {
      ot.warning("请先选择项目");
      return;
    }
    kt.value = true, Ae(c.state.config.getTreeClickTime) && c.commit("SET_CLICK_TIME"), pt(() => {
      var it;
      return (it = qt.value) == null ? void 0 : it.openInit();
    });
  }
  function wa() {
    G.value = true;
  }
  function Eo(it) {
    var Vt, Nt;
    const tt = Ct({ ...it, uid: Tt(), id: void 0, workshopId: ((Vt = m[Le[it.basicClass]]) == null ? void 0 : Vt.length) > 0 ? -1 : void 0 });
    if (tt.basicClass === Pe.SECTION_STEEL.V) {
      let Rt;
      const Pt = [];
      for (const _i in tt.specKV) _i.indexOf("standard") > -1 ? Rt = tt.specKV[_i] : Pt.push(tt.specKV[_i]);
      tt.sectionSteelSpec = Rt, tt.doNotSectionSteelSpec = Pt.join(" * ");
    }
    tt.basicClass & ct.STEEL.V && (tt.weightMeasurementMode = m.weightMeasurementMode && m.weightMeasurementMode !== Wt.MIXTURE.V ? m.weightMeasurementMode : Wt.THEORY.V, tt.weighingTotalWeight = tt.mete), m.requisitions.findIndex((Rt) => Rt.id === tt.applyPurchaseId) > -1 && (m.actualRequisitionIds.includes(tt.applyPurchaseId) || m.actualRequisitionIds.push(tt.applyPurchaseId), A(m.requisitionsKV) && A(m.requisitionsKV[tt.applyPurchaseId])), m[Le[tt.basicClass]].push(tt), (Nt = se.value) == null || Nt.rowWatch(tt), m[Ie[tt.basicClass]].push(tt);
  }
  function da(it) {
    m.currentBasicClass = it;
  }
  function Tl(it) {
    var Vt, Nt;
    const tt = m.currentBasicClass === Pe.STRUC_MANUFACTURED.V ? "structureList" : "enclosureList";
    if (A(m[tt])) {
      const Rt = m[tt].find((Pt) => Pt.finishedGoodsTypeName === it.finishedGoodsTypeName) || {};
      if (A(Rt)) Rt.list.push(...it.list), Rt.quantity = 0, Rt.totalWeight = 0, Rt.totalLength = 0, Rt.totalArea = 0, Rt.listId = [], Rt.list.forEach((Pt) => {
        Rt.listId.push(Pt.applyPurchaseDetailId), Rt.quantity += Pt.quantity || 0, Rt.totalWeight += Pt.totalWeight || 0, Rt.totalLength += Pt.totalLength || 0, Rt.totalArea += Pt.totalArea || 0;
      });
      else {
        const Pt = Ct({ ...it, uid: Tt(), id: void 0 });
        m[tt].push(Pt), (Vt = se.value) == null || Vt.rowWatch(Pt);
      }
    } else {
      const Rt = Ct({ ...it, uid: Tt(), id: void 0 });
      m[tt] = [Rt], (Nt = se.value) == null || Nt.rowWatch(Rt);
    }
  }
  function os() {
    pt(() => {
      var it;
      (it = se.value) == null || it.setFormCallback(m);
    });
  }
  R.HOOK.beforeToEdit = async (it, tt) => {
    await pt(() => {
      var Vt, Nt;
      if (zi.close(), tt.materialType & ct.STEEL.V && A(tt.list) && A(tt.id)) {
        const Rt = [];
        let Pt = [];
        const _i = [];
        if ((Vt = tt.list) == null || Vt.forEach((Yt) => {
          A(Yt.steelDensity) && Yt.steelDensity !== ao.value[Yt.classifyId] && Rt.push({ classifyName: Yt.classifyName, classifyId: Yt.classifyId });
        }), Pt = ns(Rt, "classifyId"), A(Pt)) {
          Pt.forEach((ni) => {
            _i.push(`当前【${ni.classifyName}】物料密度有变，最新密度为【${ao.value[ni.classifyId]}】`);
          });
          const Yt = _i.join(`，
`);
          tt.densityData = Pt.map((ni) => ni.classifyId), zi.confirm(`${Yt}，
是否重新计算总重？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消" }).then(() => {
            tt.densityData = Pt.map((ni) => ni.classifyId), pt(() => {
              tt.steelPlateList.forEach((ni) => {
                tt.densityData.includes(ni.classifyId) && (ni.steelDensity = ao.value[ni.classifyId], ni.weighingTotalWeight = ni.theoryTotalWeight);
              }), tt.steelCoilList.forEach((ni) => {
                tt.densityData.includes(ni.classifyId) && (ni.steelDensity = ao.value[ni.classifyId], ni.length = ni.theoryLength);
              });
            }), console.log(tt, "form");
          }).catch(() => {
            pt(() => {
              tt.steelPlateList.forEach((ni) => {
                tt.densityData.includes(ni.classifyId) && (ni.steelDensity = ao.value[ni.classifyId]);
              }), tt.steelCoilList.forEach((ni) => {
                tt.densityData.includes(ni.classifyId) && (ni.steelDensity = ao.value[ni.classifyId]);
              });
            }), tt.densityData = [];
          });
        }
      }
      (Nt = se.value) == null || Nt.setFormCallback(tt);
    }), Ii.value.serialNumber = tt.serialNumber, Ii.value.supplierId = tt.supplierId;
  };
  function ns(it, tt) {
    return it.filter((Vt, Nt, Rt) => Nt === Rt.findIndex((Pt) => tt ? Pt[tt] === Vt[tt] : JSON.stringify(Pt) === JSON.stringify(Vt)));
  }
  R.HOOK.beforeToCU = (it, tt) => {
  }, R.HOOK.afterToCU = () => {
    m.clickAddTime = (/* @__PURE__ */ new Date()).getTime();
  }, R.HOOK.beforeValidateCU = () => {
    M.value = false;
  };
  async function Cn() {
    var Rt, Pt;
    let it = true;
    const tt = [], Vt = [], Nt = [];
    if (m.orderPlace === Bt.CONSTRUCTION_SITE.V && m.projectId && V.edit && m.projectId !== m.originEditProjectId && Vt.push(m.projectId), (Rt = m.list) == null || Rt.map((_i) => {
      _i.projectId && Nt.push(_i.projectId);
    }), A(Nt) && (!V.edit || V.edit && !el(Nt, m.originEditProjectIds))) for (let _i = 0; _i < Nt.length; _i++) {
      const Yt = Nt[_i];
      (!V.edit || V.edit && !((Pt = m.originEditProjectIds) != null && Pt.includes(Yt))) && Vt.push(Yt);
    }
    for (let _i = 0; _i < Vt.length; _i++) {
      const Yt = Vt[_i];
      if (r.value.includes(Yt) && tt.findIndex((ni) => ni.id === Yt) < 0) {
        const ni = E.value.find((Ia) => Ia.id === Yt);
        tt.push(ni);
      }
    }
    if (A(tt)) {
      const _i = tt.map((Yt) => Yt.name).join("、");
      await zi.confirm(`您已经为《${_i}》创建过采购，是否继续创建，请确认?`, "提示", { distinguishCancelAndClose: true, confirmButtonText: "确认", cancelButtonText: "取消" }).then(() => {
        it = true;
      }).catch((Yt) => {
        it = false, _.value = false;
      });
    }
    return it;
  }
  const { steelDensityCfg: ao } = cn();
  yi("steelDensityCfg", ao), R.HOOK.beforeSubmit = async () => {
    var tt, Vt, Nt, Rt;
    return m.boolDetail = true, V.isPassedEdit && V.edit && (m.dataStatus === rl.PASSED.V && (f.api = Ic), m.dataStatus === rl.UNDER_APPROVAL.V && (f.api = Cc)), m.clickTime = c.state.config.getTreeClickTime, m.boolTemporaryStorage ? (se.value && ((tt = se.value) == null || tt.TSValidateTable(), (Vt = se.value) == null || Vt.getData()), await Cn()) : !((Nt = se.value) != null && Nt.validate()) || !((Rt = g.value) != null && Rt.validate()) ? false : await Cn();
  };
  const Vl = ft("dataId");
  R.HOOK.afterSubmit = async (it) => {
    Vl.value = null, Vl.value = await it.submitResult.data, ie.value = [], ue.value = [], c.dispatch("approval_list/fetchTSNum", at.PURCHASE_ORDER_V2.V), c.dispatch("approval_list/fetchSubNum", at.PURCHASE_ORDER_V2.V), c.dispatch("config/fetchSupplyUsedProject"), c.dispatch("config/fetchWmsSuppliers"), te.value = true, _.value = false, u("success");
  }, f.submitFormFormat = async (it) => {
    it.boolDetail = true, it.projectIds = [], it.attachmentIds = it.attachments ? it.attachments.map((Vt) => Vt.id) : void 0, it.auxMaterialIds = it.isAllMaterial ? [0] : it.auxMaterialIds, it.otherMaterialIds = it.isAllOtherMaterial ? [0] : it.otherMaterialIds, it.gasMaterialIds = it.isAllGAS ? [0] : it.gasMaterialIds;
    const tt = [];
    if (it.useRequisitions) {
      it.applyPurchaseIds = it.actualRequisitionIds;
      const Vt = [];
      for (const Nt in it.requisitionsKV) it.requisitionsKV[Nt].purchaseCreationState && Vt.push({ id: it.requisitionsKV[Nt].id });
      it.applyPurchaseStatus = JSON.stringify(Vt);
    } else it.applyPurchaseIds = [], it.applyPurchaseStatus = "";
    if (it.basicClass = it.currentBasicClass, it.projects = [], it.projectIds = [], it.projectId && it.projectIds.push(it.projectId), it.list.map((Vt) => {
      it.basicClass = it.basicClass | Vt.basicClass, !tt.includes(Vt.weightMeasurementMode) && Vt.weightMeasurementMode && tt.push(Vt.weightMeasurementMode), it.level === Bt.CONSTRUCTION_SITE.V && (Vt.projectId = it.projectId), !it.projects.includes(Vt.projectId) && Vt.projectId && it.projects.push(Vt.projectId), Vt.projectId && !it.projectIds.includes(Vt.projectId) && it.projectIds.push(Vt.projectId);
    }), it.weightMeasurementMode = tt != null && tt.length ? (tt == null ? void 0 : tt.length) > 1 ? Wt.MIXTURE.V : tt[0] : void 0, !j.value) it.list.forEach((Vt) => {
      Vt.originChange && (it.delDetailIds.push(Vt.id), Vt.id = void 0, Vt.boolOriginalDetail = false);
    }), it.list = await Ut(it.list, { toSmallest: true, toNum: true });
    else {
      it.projectId && (it.projectIds = [it.projectId]), it.list = [];
      const Vt = [];
      it.structureList.forEach((Nt) => {
        var Rt;
        (Rt = Nt.list) == null || Rt.forEach((Pt) => {
          Vt.push(Pt);
        });
      }), it.enclosureList.forEach((Nt) => {
        var Rt;
        (Rt = Nt.list) == null || Rt.forEach((Pt) => {
          Vt.push(Pt);
        });
      }), await fo(Vt, { toSmallest: true, toNum: true }), Vt.forEach((Nt) => {
        it.list.push({ boolOriginalDetail: Nt.boolOriginalDetail, id: Nt.originId, applyPurchaseId: Nt.applyPurchaseId, applyPurchaseDetailId: Nt.applyPurchaseDetailId, finishedGoodsTypeName: Nt.finishedGoodsTypeName, manufacturedSpecification: Nt.manufacturedSpecification, wageQuotaType: Nt.wageQuotaType, manufacturedUnit: Nt.manufacturedUnit, quantity: Nt.quantity, unitPrice: Nt.unitPrice });
      });
    }
    return it;
  };
  async function Qo() {
    var Nt;
    if (await S.value && S.value.resetQuery(), A(re.value)) return ot.error("请先删除标红数据并重新添加"), false;
    if (!((Nt = se.value) != null && Nt.validate()) || !await g.value.validate()) return false;
    const tt = [];
    let Vt = true;
    if (A(y.value) && y.value.forEach((Rt) => {
      var _i;
      const Pt = (_i = m.list) == null ? void 0 : _i.filter((Yt) => Yt.basicClass === Rt.basicClass);
      A(Pt) && Pt.forEach((Yt) => {
        Rt.minPrice && Yt.unitPrice < Rt.minPrice && tt.push({ msg: `${Pe.VL[Yt.basicClass]} ${Yt.serialNumber} ${Yt.classifyName}：单价${Yt.unitPrice} < 异常配置最小值${Rt.minPrice}` }), Rt.maxPrice && Yt.unitPrice > Rt.maxPrice && tt.push({ msg: `${Pe.VL[Yt.basicClass]} ${Yt.serialNumber} ${Yt.classifyName}：单价${Yt.unitPrice} > 异常配置最大值${Rt.maxPrice}` });
      });
    }), A(tt)) {
      const Rt = tt.map((Pt) => `<div>${Pt.msg}<div>`).join("");
      await zi.confirm("<div>单价异常明细如下,请确认！<div>" + Rt, "提示", { dangerouslyUseHTMLString: true, distinguishCancelAndClose: true, closeOnClickModal: false, closeOnPressEscape: false, confirmButtonText: "已确认，直接下一步", cancelButtonText: "好的，现在去确认" }).then(() => {
        Vt = true;
      }).catch((Pt) => {
        Vt = false;
      });
    }
    Vt && (h.value = true);
  }
  yi("dataId", Vl);
  async function Sa(it) {
    _.value = true;
    try {
      if (m.purchaseType === Fi.MANUFACTURED.V) m.boolTemporaryStorage = false;
      else {
        if (A(re.value)) return ot.error("请先删除标红数据并重新添加"), false;
        m.boolTemporaryStorage = !!it;
      }
      console.log(m, "form11111 submit"), await f.submit(), te.value = false;
    } catch (tt) {
      console.log("采购合同提交", tt);
    } finally {
      _.value = false;
    }
  }
  return o({ nextSubmit: Qo, submit: Sa, setFormCallback: os, purchaseType: v, fetchManufList: Oe }), (it, tt) => {
    const Vt = Ve("common-select"), Nt = Zi, Rt = qa, Pt = Ve("common-select-v2"), _i = Mt, Yt = Fo, ni = Ga, Ia = Ml, la = Ve("common-radio-button"), Yl = wi, Or = Ve("common-button"), Bs = jt, T6 = Li, T2 = Ve("common-drawer"), _6 = oi;
    return w(), Q("div", null, [qe((w(), Q("div", HJ, [s(T6, { ref_key: "detailFormRef", ref: g, model: l(m), rules: ae.value, "label-position": "right", "label-width": "110px", size: "default" }, { default: p(() => {
      var Bl, _2, b2, V2;
      return [C("div", qJ, [C("div", { style: ri(M.value ? "width:0px;padding:0;" : "height:auto"), class: "form-left" }, [s(ni, { key: "list", column: 4, border: "", style: { "margin-bottom": "10px" } }, { default: p(() => [s(Rt, { key: "purchaseType", label: "采购类型", "label-class-name": "contractLabel needItem" }, { default: p(() => [s(Nt, { class: "el-form-item-18", label: "", "label-width": "0", prop: "purchaseType" }, { default: p(() => [s(Vt, { modelValue: l(m).purchaseType, "onUpdate:modelValue": tt[0] || (tt[0] = ($t) => l(m).purchaseType = $t), disabled: !!l(m).id || l(m).isRequisitionOrigin, options: l(Fi).ENUM, class: "input-underline", size: "default", type: "enum", onChange: He }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })]), _: 1 }), s(Rt, { key: "materialTypeTotal", label: "材料类型", "label-class-name": "contractLabel needItem" }, { default: p(() => [s(Nt, { class: "el-form-item-3", label: "", "label-width": "0", prop: "materialTypeTotal" }, { default: p(() => [l(m).purchaseType === l(Fi).RAW_MATERIAL.V ? (w(), U(Vt, { key: 0, modelValue: l(m).materialTypeTotal, "onUpdate:modelValue": tt[1] || (tt[1] = ($t) => l(m).materialTypeTotal = $t), disabled: !!l(m).boolUsed || l(m).isRequisitionOrigin, disabledVal: l(A)(l(m).materialTypeTotal) ? l(m).materialTypeTotal.includes(l(ct).STEEL.V) ? [l(ct).MATERIAL.V, l(ct).OTHER.V, l(ct).GAS.V] : [l(ct).STEEL.V] : [], options: l(Xs).ENUM, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择材料类型", type: "enum", onClear: me }, null, 8, ["modelValue", "disabled", "disabledVal", "options"])) : (w(), U(Pt, { key: 1, modelValue: l(m).materialTypeTotal, "onUpdate:modelValue": tt[2] || (tt[2] = ($t) => l(m).materialTypeTotal = $t), disabled: !!l(m).boolUsed, options: l(Rc).ENUM, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择材料类型", type: "enum" }, null, 8, ["modelValue", "disabled", "options"]))]), _: 1 })]), _: 1 }), l(m).purchaseType !== l(Fi).MANUFACTURED.V ? (w(), U(Rt, { key: "boolAnnual", label: "合同类型", "label-class-name": "contractLabel needItem" }, { default: p(() => [s(Nt, { label: "", "label-width": "0", prop: "boolAnnual", required: "" }, { default: p(() => [s(Vt, { modelValue: l(m).boolAnnual, "onUpdate:modelValue": tt[3] || (tt[3] = ($t) => l(m).boolAnnual = $t), disabled: !!l(m).id && !!l(m).boolUsed, options: l(Vn).ENUM, class: "input-underline", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })]), _: 1 })) : H("", true), l(m).purchaseType !== l(Fi).MANUFACTURED.V ? (w(), U(Rt, { key: "isRequisitionOrigin", label: "是否绑定申购", "label-class-name": "contractLabel needItem" }, { default: p(() => [s(Nt, { label: "", "label-width": "0", prop: "useRequisitions", required: "" }, { default: p(() => [s(Vt, { modelValue: l(m).useRequisitions, "onUpdate:modelValue": tt[4] || (tt[4] = ($t) => l(m).useRequisitions = $t), disabled: !!l(m).boolUsed || l(m).isRequisitionOrigin, options: l(ea).ENUM, class: "input-underline", type: "enum", onChange: ge }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })]), _: 1 })) : H("", true), s(Rt, { key: "serialNumber", label: "采购合同编号", "label-class-name": "contractLabel" }, { default: p(() => [s(Nt, { class: "el-form-item-1", label: "", "label-width": "0", prop: "serialNumber" }, { default: p(() => [s(_i, { modelValue: l(m).serialNumber, "onUpdate:modelValue": tt[5] || (tt[5] = ($t) => l(m).serialNumber = $t), modelModifiers: { trim: true }, disabled: !!l(m).id && !!l(m).boolUsed, class: "input-underline", maxlength: "30", placeholder: "可输入采购合同编号（不填写则自动生成）", size: "default" }, null, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 }), s(Rt, { key: "branchCompanyId", label: "采购单位", "label-class-name": "contractLabel needItem" }, { default: p(() => [s(Nt, { class: "el-form-item-18", label: "", "label-width": "0", prop: "branchCompanyId" }, { default: p(() => [s(M_, { modelValue: l(m).branchCompanyId, "onUpdate:modelValue": tt[6] || (tt[6] = ($t) => l(m).branchCompanyId = $t), disabled: !!l(m).boolUsed || ce.value || l(m).isRequisitionOrigin, class: "input-underline", placeholder: "采购单位", style: { width: "100%" }, onChange: Ne, onCurrentChange: Me }, null, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 }), s(Rt, { "label-class-name": "contractLabel needItem", key: "orderPlace", label: "目的地" }, { default: p(() => [s(Nt, { class: "el-form-item-18", label: "", prop: "orderPlace", "label-width": "0" }, { default: p(() => [s(Vt, { modelValue: l(m).orderPlace, "onUpdate:modelValue": tt[7] || (tt[7] = ($t) => l(m).orderPlace = $t), disabled: !!l(m).boolUsed || l(m).level === l(Bt).CONSTRUCTION_SITE.V, options: l(Bt).ENUM, size: "default", class: "input-underline", type: "enum", onChange: Je }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })]), _: 1 }), l(m).orderPlace === l(Bt).FACTORY.V ? (w(), U(Rt, { "label-class-name": "contractLabel needItem", label: "关联车间", key: "boolAnnual" }, { default: p(() => [s(Nt, { class: "el-form-item-18", label: "", prop: "workshopId", "label-width": "0" }, { default: p(() => [s(pu, { modelValue: l(m).workshopId, "onUpdate:modelValue": tt[8] || (tt[8] = ($t) => l(m).workshopId = $t), class: "input-underline", clearable: "", placeholder: "可选择关联车间" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })) : H("", true), s(Rt, { "label-class-name": "contractLabel needItem", key: "supplierId", label: "供应商" }, { default: p(() => [s(Nt, { class: "el-form-item-7", label: "", "label-width": "0", prop: "supplierId" }, { default: p(() => [s(pd, { ref_key: "supplierRef", ref: T, modelValue: l(m).supplierId, "onUpdate:modelValue": tt[9] || (tt[9] = ($t) => l(m).supplierId = $t), "basic-class": l(m).materialType, disableOptions: ie.value, disabled: !!l(m).id && !!l(m).boolUsed, isAnnual: l(m).boolAnnual, type: l(m).purchaseType, class: "input-underline", clearable: "", filterable: "", mode: "cross", onChange: Xe, onInfoChange: Ye }, null, 8, ["modelValue", "basic-class", "disableOptions", "disabled", "isAnnual", "type"])]), _: 1 })]), _: 1 }), s(Rt, { key: "invoiceType", label: "发票及税率", "label-class-name": "contractLabel needItem" }, { default: p(() => [s(Nt, { class: "el-form-item-10", label: "", "label-width": "0", prop: "invoiceType" }, { default: p(() => [s(Xn, { invoiceType: l(m).invoiceType, "onUpdate:invoiceType": tt[10] || (tt[10] = ($t) => l(m).invoiceType = $t), taxRate: l(m).taxRate, "onUpdate:taxRate": tt[11] || (tt[11] = ($t) => l(m).taxRate = $t), classification: l(m).materialType, disabled: !!l(m).boolUsed, class: "input-underline" }, null, 8, ["invoiceType", "taxRate", "classification", "disabled"])]), _: 1 })]), _: 1 }), s(Rt, { key: "logisticsTransportType", label: "物流运输方式", "label-class-name": "contractLabel needItem" }, { default: p(() => [s(Nt, { class: "el-form-item-16", label: "", "label-width": "0", prop: "logisticsTransportType" }, { default: p(() => [s(Vt, { modelValue: l(m).logisticsTransportType, "onUpdate:modelValue": tt[12] || (tt[12] = ($t) => l(m).logisticsTransportType = $t), disabled: !!l(m).boolUsed, options: l(Xa).ENUM, class: "input-underline", size: "default", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })]), _: 1 }), s(Rt, { key: "logisticsPayerType", label: "物流费用承担", "label-class-name": "contractLabel needItem" }, { default: p(() => [s(Nt, { class: "el-form-item-17", label: "", "label-width": "0", prop: "logisticsPayerType" }, { default: p(() => [s(Vt, { modelValue: l(m).logisticsPayerType, "onUpdate:modelValue": tt[13] || (tt[13] = ($t) => l(m).logisticsPayerType = $t), disabled: !!l(m).boolUsed, options: l(Bi).ENUM, class: "input-underline", size: "default", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })]), _: 1 }), l(m).level === l(Bt).CONSTRUCTION_SITE.V || l(m).materialType & l(ct).MANUFACTURED.V ? (w(), U(Rt, { key: "projectId", label: "项目", "label-class-name": "contractLabel needItem" }, { default: p(() => [s(Nt, { class: "el-form-item-4", label: "", "label-width": "0", prop: "projectId" }, { default: p(() => [s(l(ca), { key: "siteProjectId", modelValue: l(m).projectId, "onUpdate:modelValue": tt[14] || (tt[14] = ($t) => l(m).projectId = $t), branchCompanyId: l(m).branchCompanyId, disabled: !!l(m).boolUsed || !l(m).branchCompanyId || l(m).level === l(Bt).CONSTRUCTION_SITE.V && l(m).isRequisitionOrigin, class: "input-underline", placeholder: "可选择项目搜索", onChange: fe, onProjectChange: Ue }, null, 8, ["modelValue", "branchCompanyId", "disabled"])]), _: 1 })]), _: 1 })) : H("", true), l(m).materialType & l(ct).STEEL.V ? (w(), U(Rt, { key: "purchaseOrderPaymentMode", label: "订单类型", "label-class-name": "contractLabel needItem" }, { default: p(() => [s(Nt, { class: "el-form-item-13", label: "", "label-width": "0", prop: "purchaseOrderPaymentMode" }, { default: p(() => [s(Vt, { modelValue: l(m).purchaseOrderPaymentMode, "onUpdate:modelValue": tt[15] || (tt[15] = ($t) => l(m).purchaseOrderPaymentMode = $t), disabled: !!l(m).boolUsed, options: l(Jl).ENUM, size: "small", class: "input-underline", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })]), _: 1 })) : H("", true), l(m).materialType & l(ct).MATERIAL.V && !l(m).useRequisitions ? (w(), U(Rt, { key: "auxMaterialIds", label: "辅材明细", "label-class-name": "contractLabel needItem" }, { default: p(() => [s(Nt, { class: "el-form-item-5", label: "", "label-width": "0", prop: "auxMaterialIds" }, { default: p(() => [C("div", GJ, [s(Yt, { key: "isAllMaterial", modelValue: l(m).isAllMaterial, "onUpdate:modelValue": tt[16] || (tt[16] = ($t) => l(m).isAllMaterial = $t), disabled: !!l(m).boolUsed, border: "", label: "所有辅材", size: "default", style: { "margin-top": "3px", "margin-right": "5px" }, onChange: tt[17] || (tt[17] = ($t) => l(m).auxMaterialIds = []) }, null, 8, ["modelValue", "disabled"]), s(Ql, { modelValue: l(m).auxMaterialIds, "onUpdate:modelValue": tt[18] || (tt[18] = ($t) => l(m).auxMaterialIds = $t), "basic-class": l(Pe).MATERIAL.V, "collapse-tags": false, deep: 2, disabled: l(m).boolUsed ? !!l(m).boolUsed : l(m).isAllMaterial, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择辅材", separator: " > ", size: "default" }, null, 8, ["modelValue", "basic-class", "disabled"])])]), _: 1 })]), _: 1 })) : H("", true), l(m).materialType & l(ct).OTHER.V && !l(m).useRequisitions ? (w(), U(Rt, { key: "otherMaterialIds", label: "办公用品明细", "label-class-name": "contractLabel needItem" }, { default: p(() => [s(Nt, { class: "el-form-item-5", label: "", "label-width": "0", prop: "otherMaterialIds" }, { default: p(() => [C("div", QJ, [s(Yt, { key: "isAllOtherMaterial", modelValue: l(m).isAllOtherMaterial, "onUpdate:modelValue": tt[19] || (tt[19] = ($t) => l(m).isAllOtherMaterial = $t), disabled: l(m).boolUsed, border: "", label: "所有办公用品科目", size: "default", style: { "margin-top": "3px", "margin-right": "5px" }, onChange: tt[20] || (tt[20] = ($t) => l(m).otherMaterialIds = []) }, null, 8, ["modelValue", "disabled"]), s(Ql, { modelValue: l(m).otherMaterialIds, "onUpdate:modelValue": tt[21] || (tt[21] = ($t) => l(m).otherMaterialIds = $t), "basic-class": l(Pe).OTHER.V, "collapse-tags": false, deep: 2, disabled: l(m).boolUsed ? !!l(m).boolUsed : l(m).isAllOtherMaterial, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择办公用品科目", separator: " > ", size: "default" }, null, 8, ["modelValue", "basic-class", "disabled"])])]), _: 1 })]), _: 1 })) : H("", true), l(m).materialType & l(ct).GAS.V && !l(m).useRequisitions ? (w(), U(Rt, { key: "gasMaterialIds", label: "气体明细", "label-class-name": "contractLabel needItem" }, { default: p(() => [s(Nt, { class: "el-form-item-5", label: "", "label-width": "0", prop: "gasMaterialIds" }, { default: p(() => [C("div", ZJ, [s(Yt, { key: "isAllGAS", modelValue: l(m).isAllGAS, "onUpdate:modelValue": tt[22] || (tt[22] = ($t) => l(m).isAllGAS = $t), disabled: l(m).boolUsed, border: "", label: "所有气体科目", size: "default", style: { "margin-top": "3px", "margin-right": "5px" }, onChange: tt[23] || (tt[23] = ($t) => l(m).gasMaterialIds = []) }, null, 8, ["modelValue", "disabled"]), s(Ql, { modelValue: l(m).gasMaterialIds, "onUpdate:modelValue": tt[24] || (tt[24] = ($t) => l(m).gasMaterialIds = $t), "basic-class": l(Pe).GAS.V, "collapse-tags": false, deep: 2, disabled: l(m).boolUsed ? !!l(m).boolUsed : l(m).isAllGAS, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择气体科目", separator: " > ", size: "default" }, null, 8, ["modelValue", "basic-class", "disabled"])])]), _: 1 })]), _: 1 })) : H("", true), l(m).purchaseType === l(Fi).MANUFACTURED.V ? (w(), U(Rt, { key: "actualRequisitionIds", label: "申购单", "label-class-name": "contractLabel needItem" }, { default: p(() => [s(Nt, { class: "el-form-item-13", label: "", "label-width": "0", prop: "actualRequisitionIds" }, { default: p(() => [s(Vt, { key: "actualRequisitionIds", modelValue: l(m).actualRequisitionIds, "onUpdate:modelValue": tt[25] || (tt[25] = ($t) => l(m).actualRequisitionIds = $t), dataStructure: { key: "id", label: "serialNumber", value: "id" }, disabled: !!l(m).boolUsed || !l(m).projectId || l(m).isRequisitionOrigin, options: ne.value, class: "input-underline", multiple: "", placeholder: "请选择申购单", size: "default", type: "other", onChange: ze }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })]), _: 1 })) : H("", true), l(m).purchaseType === l(Fi).MANUFACTURED.V ? (w(), U(Rt, { key: "artifactWageQuotaType", label: "结构计价方式", "label-class-name": "contractLabel needItem" }, { default: p(() => [s(Nt, { class: "el-form-item-13", label: "", "label-width": "0", prop: "artifactWageQuotaType" }, { default: p(() => [s(Vt, { modelValue: l(m).artifactWageQuotaType, "onUpdate:modelValue": tt[26] || (tt[26] = ($t) => l(m).artifactWageQuotaType = $t), disabled: !!l(m).boolUsed, options: l(ha).ENUM, size: "small", class: "input-underline", type: "enum", onChange: tt[27] || (tt[27] = ($t) => Re("artifact")) }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })]), _: 1 })) : H("", true)]), _: 1 })], 4), C("div", { style: ri(M.value ? "display:none;" : ""), class: "vertical-dashed-divider" }, null, 4), C("div", JJ, [s(Ia, null, { default: p(() => tt[36] || (tt[36] = [C("span", { class: "title" }, "采购清单", -1)])), _: 1, __: [36] }), l(A)(l(m).materialTypeTotal) ? (w(), Q("div", XJ, [l(m).useRequisitions ? (w(), Q("div", $J, [C("span", eX, [tt[37] || (tt[37] = C("span", { class: "label" }, "关联申购单号", -1)), s(la, { modelValue: l(m).currentBasicClass, "onUpdate:modelValue": tt[28] || (tt[28] = ($t) => l(m).currentBasicClass = $t), "data-structure": { key: "V", label: "L", value: "V" }, options: le.value, clearable: "", style: { "vertical-align": "middle", "margin-right": "6px" }, type: "other" }, { suffix: p(({ item: $t }) => {
        var Hl, Zo;
        return [(Hl = l(m)[Le[$t.V]]) != null && Hl.length ? (w(), Q("span", tX, "(" + K((Zo = l(m)[Le[$t.V]]) == null ? void 0 : Zo.length) + ")", 1)) : H("", true)];
      }), _: 1 }, 8, ["modelValue", "options"]), l(m).purchaseType === l(Fi).MANUFACTURED.V ? (w(true), Q(Qe, { key: 0 }, ki(l(m).actualRequisitionIds, ($t) => (w(), Q("span", { key: $t }, [s(Yl, { class: "preparation-sn-tag", effect: "plain" }, { default: p(() => {
        var Hl;
        return [Te(K((Hl = ne.value.find((Zo) => Zo.id === $t)) == null ? void 0 : Hl.serialNumber), 1)];
      }), _: 2 }, 1024)]))), 128)) : (w(true), Q(Qe, { key: 1 }, ki(l(m).actualRequisitionIds, ($t) => (w(), Q("span", { key: $t }, [s(Yl, { class: "preparation-sn-tag", effect: "plain" }, { default: p(() => {
        var Hl, Zo;
        return [Te(K((Zo = (Hl = l(m).requisitionsKV) == null ? void 0 : Hl[$t]) == null ? void 0 : Zo.serialNumber), 1)];
      }), _: 2 }, 1024)]))), 128))]), C("span", iX, [j.value ? H("", true) : (w(), U(Bs, { key: 0, content: "请删除全部标红数据", disabled: !(l(A)(re.value) && l(A)((_2 = (Bl = l(f)) == null ? void 0 : Bl.submitResult) == null ? void 0 : _2.data)), class: "item", effect: "dark", placement: "top" }, { default: p(() => {
        var $t, Hl;
        return [s(Or, { disabled: l(A)(re.value) && l(A)((Hl = ($t = l(f)) == null ? void 0 : $t.submitResult) == null ? void 0 : Hl.data), size: "default", type: "success", onClick: ra }, { default: p(() => tt[38] || (tt[38] = [Te(" 选择申购物料 ")])), _: 1, __: [38] }, 8, ["disabled"])];
      }), _: 1 }, 8, ["disabled"])), j.value ? (w(), U(Or, { key: 1, size: "default", type: "success", onClick: wa }, { default: p(() => tt[39] || (tt[39] = [Te(" 选择申购物料 ")])), _: 1, __: [39] })) : H("", true)])])) : H("", true), C("div", aX, [C("span", lX, [l(m).useRequisitions ? H("", true) : (w(), Q("span", oX, "采购清单")), l(m).useRequisitions ? H("", true) : (w(), U(la, { key: 1, modelValue: l(m).currentBasicClass, "onUpdate:modelValue": tt[29] || (tt[29] = ($t) => l(m).currentBasicClass = $t), "data-structure": { key: "V", label: "L", value: "V" }, options: le.value, clearable: "", style: { "vertical-align": "middle" }, type: "other" }, { suffix: p(({ item: $t }) => {
        var Hl, Zo;
        return [(Hl = l(m)[Le[$t.V]]) != null && Hl.length ? (w(), Q("span", nX, "(" + K((Zo = l(m)[Le[$t.V]]) == null ? void 0 : Zo.length) + ")", 1)) : H("", true)];
      }), _: 1 }, 8, ["modelValue", "options"])), l(m).useRequisitions && !l(m).id && l(m).branchCompanyId && l(m).currentBasicClass ? (w(), Q(Qe, { key: 2 }, [s(l(qR), { data: $.value, class: "filter-item", size: "default", template: Se.value, "btn-name": l(Pe).VL[l(m).currentBasicClass] + "明细导出", type: "primary" }, null, 8, ["data", "template", "btn-name"]), s(Ro, { template: X.value, "btn-name": l(Pe).VL[l(m).currentBasicClass] + "修改后清单导入", "btn-size": "default", "btn-type": "warning", class: "filter-item", icon: "el-icon-upload", "open-loading": "", style: { "margin-left": "10px" }, onSuccess: et }, null, 8, ["template", "btn-name"])], 64)) : H("", true), s(Or, { size: "default", type: "warning", onClick: Pi(Ke, ["stop"]) }, { default: p(() => tt[40] || (tt[40] = [Te("批量删除")])), _: 1, __: [40] })]), C("span", sX, [j.value ? H("", true) : (w(), U(Or, { key: 0, disabled: !l(m).projectAttribute || l(m).orderPlace === l(Bt).CONSTRUCTION_SITE.V && !l(m).projectId, class: "filter-item", size: "default", type: "success", onClick: bt }, { default: p(() => tt[41] || (tt[41] = [Te(" 添加物料 ")])), _: 1, __: [41] }, 8, ["disabled"])), j.value ? H("", true) : (w(), U(Bs, { key: 1, content: "请删除全部标红数据", disabled: !(l(A)(re.value) && l(A)((V2 = (b2 = l(f)) == null ? void 0 : b2.submitResult) == null ? void 0 : V2.data)), class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(Ro, { template: k.value, "btn-name": "清单导入", "btn-size": "default", "btn-type": "warning", class: "filter-item", icon: "el-icon-upload", "open-loading": "", style: { "margin-left": "10px" }, onSuccess: gt }, null, 8, ["template"])]), _: 1 }, 8, ["disabled"])), j.value ? H("", true) : (w(), U(ia, { key: 2, fn: l(uu), params: { basicClass: l(m).currentBasicClass, receiptType: l(It).PURCHASE.V }, class: "filter-item", style: { "margin-left": "10px" }, type: "info" }, { default: p(() => [Te(K(l(Pe).VL[l(m).currentBasicClass]) + "清单模板下载 ", 1)]), _: 1 }, 8, ["fn", "params"]))])]), (w(), U(Ri(ye.value), { ref_key: "compRef", ref: se, maxHeight: e.maxHeight - 260 }, null, 8, ["maxHeight"])), C("div", rX, [l(m).materialType & l(ct).STEEL.V ? (w(), Q(Qe, { key: 0 }, [tt[42] || (tt[42] = C("span", { class: "title" }, "合同量", -1)), C("span", uX, [C("span", null, K(l(Be)(l(m).mete, l(ei).weight.precision)), 1), C("span", null, K(l(m).meteUnit), 1)])], 64)) : H("", true), tt[43] || (tt[43] = C("span", { class: "title" }, "合同额", -1)), C("span", cX, K(l(m).amount) + " 元", 1)])])) : (w(), Q("div", dX, "*请先选择材料类型"))])])];
    }), _: 1 }, 8, ["model", "rules"])])), [[_6, _.value]]), s(T2, { modelValue: kt.value, "onUpdate:modelValue": tt[30] || (tt[30] = (Bl) => kt.value = Bl), "custom-class": "material-requisition-select", direction: "btt", size: "70%", title: "申购选择" }, { titleRight: p(() => tt[44] || (tt[44] = [])), content: p(() => [s(e2, { ref_key: "requisitionListRef", ref: qt, projectId: l(m).orderPlace === l(Bt).CONSTRUCTION_SITE.V ? l(m).projectId : void 0, tableVisible: kt.value, onRequisitionBasicClassChange: da, onAddPurchase: Eo }, null, 8, ["projectId", "tableVisible"])]), _: 1 }, 8, ["modelValue"]), s(T2, { ref_key: "materialSpecSelectDrawer", ref: J, modelValue: F.value, "onUpdate:modelValue": tt[32] || (tt[32] = (Bl) => F.value = Bl), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: p(() => [s(to, { ref_key: "matSpecRef", ref: z, modelValue: l(m)[Le[l(m).currentBasicClass]], "onUpdate:modelValue": tt[31] || (tt[31] = (Bl) => l(m)[Le[l(m).currentBasicClass]] = Bl), "basic-class": l(m).currentBasicClass, "classify-ids": l(m).materialType & l(ct).MATERIAL.V ? l(m).auxMaterialIds : l(m).materialType & l(ct).OTHER.V ? l(m).otherMaterialIds : [], "max-height": l(we), "row-init-fn": Fe, "table-width": 350, visible: F.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "classify-ids", "max-height", "visible"])]), _: 1 }, 8, ["modelValue"]), s(LR, { modelValue: h.value, "onUpdate:modelValue": tt[33] || (tt[33] = (Bl) => h.value = Bl), edit: V.edit, "is-passed-edit": e.isPassedEdit, isClose: te.value, onSubmit: Sa }, null, 8, ["modelValue", "edit", "is-passed-edit", "isClose"]), s(KR, { modelValue: G.value, "onUpdate:modelValue": tt[34] || (tt[34] = (Bl) => G.value = Bl), actualRequisitionIds: l(m).actualRequisitionIds, projectId: l(m).projectId, onAddManufSuccess: Tl }, null, 8, ["modelValue", "actualRequisitionIds", "projectId"]), s(t3, { list: de.value, modelValue: pe.value, "onUpdate:modelValue": tt[35] || (tt[35] = (Bl) => pe.value = Bl), "basic-class": l(m).currentBasicClass, onSuccess: lt, form: l(m) }, null, 8, ["list", "modelValue", "basic-class", "form"])]);
  };
} }, n3 = ut(mX, [["__scopeId", "data-v-adfd0da9"]]), pX = Object.freeze(Object.defineProperty({ __proto__: null, default: n3 }, Symbol.toStringTag, { value: "Module" }));
function hX(e) {
  return W({ url: "/api/oa/flow/doCheckPermission", method: "get", params: e });
}
const fX = { class: "main-content" }, gX = { class: "flex-rss child-mr-10" }, EX = { class: "flex-rss child-mr-10" }, yX = { class: "flex-rss child-mr-10" }, TX = { class: "input-underline flex-rss child-mr-10" }, _X = { class: "input-underline flex-rss child-mr-10" }, bX = { __name: "raw-material", props: { edit: { type: Boolean, default: false }, dialogVisible: { type: Boolean, default: false }, detail: { type: Object }, maxHeight: { type: Number, default: 100 }, heightStyle: { type: String, default: "" }, isPassedEdit: { type: Boolean, default: false } }, emits: "success", setup(e, { expose: o, emit: n }) {
  const c = Ht(), u = { boolTemporaryStorage: false, boolDetail: false, isGoForOaApproval: true, serialNumber: void 0, boolAnnual: true, boolPartyA: false, supplyType: Ni.SELF.V, purchaseType: Fi.RAW_MATERIAL.V, basicClass: null, isAllMaterial: false, auxMaterialIds: void 0, isAllOtherMaterial: false, otherMaterialIds: void 0, projectIds: void 0, projectId: void 0, requisitionsSN: void 0, supplierId: void 0, branchCompanyId: void 0, mete: void 0, amount: void 0, invoiceType: fi.SPECIAL.V, taxRate: void 0, weightMeasurementMode: Wt.THEORY.V, logisticsTransportType: Xa.FREIGHT.V, logisticsPayerType: Bi.SUPPLIER.V, purchaseOrderPaymentMode: Jl.ARRIVAL.V, projectAttribute: vl.SELF_SUPPORT.V, remark: void 0, attachments: void 0, attachmentIds: void 0, list: [], orderPlace: void 0 }, r = n, E = Z(), y = Z([]), b = ft("supplyUsedProject"), V = ft("projectAllType"), M = e, { cu: g, form: S, FORM: h } = Pa({ title: "采购合同", formStore: !M.edit, formStoreKey: "SUPPLY_CHAIN_PURCHASE_ORDER", defaultForm: u, useDraftCallback: T, clearDraftCallback: _, api: M.edit ? Pc : x1 }, E, M.detail);
  yi("cu", g);
  function T() {
  }
  function _() {
  }
  const f = (Ie, Se, X) => {
    S.invoiceType ? (S.invoiceType === fi.SPECIAL.V || S.invoiceType === fi.ORDINARY.V) && Ae(S.taxRate) ? X(new Error("请选择税率")) : X() : X(new Error("请选择"));
  }, m = Ee(() => S.purchaseType), R = { serialNumber: [{ max: 30, message: "订单编号长度不可超过30位", trigger: "blur" }], boolAnnual: [{ required: true, message: "请选择", trigger: "change" }], supplyType: [{ required: true, message: "请选择", trigger: "change" }], orderPlace: [{ required: true, message: "请选择", trigger: "change" }], purchaseType: [{ required: true, message: "请选择", trigger: "change" }], basicClass: [{ required: true, message: "请选择", trigger: "change" }], supplierId: [{ required: true, message: "请选择", trigger: "change" }], branchCompanyId: [{ required: true, message: "请选择", trigger: "change" }], projectAttribute: [{ required: true, message: "请选择", trigger: "change" }], projectId: [{ required: true, message: "请选择", trigger: "change" }], workshopId: [{ required: true, message: "请选择关联车间", trigger: "change" }] }, v = { supplierId: [{ required: true, message: "请选择", trigger: "change" }] }, N = { weightMeasurementMode: [{ required: true, message: "请选择", trigger: "change" }], logisticsTransportType: [{ required: true, message: "请选择", trigger: "change" }], logisticsPayerType: [{ required: true, message: "请选择", trigger: "change" }], purchaseOrderPaymentMode: [{ required: true, message: "请选择", trigger: "change" }], invoiceType: [{ required: true, validator: f, trigger: "change" }], taxRate: [{ max: 2, message: "请选择", trigger: "blur" }], mete: [{ required: true, message: "请填写", trigger: "blur" }], amount: [{ required: true, message: "请填写", trigger: "blur" }] }, P = { projectIds: [{ required: true, message: "请选择", trigger: "change" }] }, O = { auxMaterialIds: [{ required: true, validator: (Ie, Se, X) => {
    S.isAllMaterial || Se ? X() : X(new Error("请选择"));
  }, trigger: "change" }] }, I = { otherMaterialIds: [{ required: true, validator: (Ie, Se, X) => {
    S.isAllOtherMaterial || Se ? X() : X(new Error("请选择办公用品"));
  }, trigger: "change" }] }, Y = Ee(() => {
    pt(() => {
      E.value && E.value.clearValidate();
    });
    const Ie = {};
    return Object.assign(Ie, R), S.boolPartyA ? (Object.assign(Ie, P), delete Ie.supplierId) : Object.assign(Ie, N), S.basicClass & Pe.MATERIAL.V && Object.assign(Ie, O), S.basicClass & Pe.OTHER.V && Object.assign(Ie, I), S.boolTemporaryStorage ? v : Ie;
  });
  Dt(() => {
    M.dialogVisible && pt(() => {
      E.value && E.value.clearValidate();
    });
  }), Ce(() => {
    var Ie;
    return (Ie = M.detail) == null ? void 0 : Ie.isGoForOaApproval;
  }, (Ie) => {
    S.isGoForOaApproval = Ie;
  }, { immedoate: true });
  function ee(Ie) {
    Ie === Fi.MANUFACTURED.V && (S.boolAnnual = Vn.NOT_YEAR.V);
  }
  function B(Ie) {
    S.branchCompany = Ie || {}, S.projectIds = [], S.projectId = void 0, S.orderPlace = Bt.FACTORY.V, S.level = Ie == null ? void 0 : Ie.level;
  }
  function q(Ie) {
    let Se = [];
    A(Ie == null ? void 0 : Ie.basicClass) && (Se = Ra.getBits(Pe.ENUM, Ie.basicClass, "V"));
    const X = [];
    for (let k = 0; k < Se.length; k++) X.push({ V: Se[k] });
    const $ = [];
    for (const k in Pe.ENUM) X.findIndex((J) => J.V & Pe.ENUM[k].V) < 0 && ($.includes(Pe.ENUM[k].V) || $.push(Pe.ENUM[k].V));
    y.value = S.id ? $ : [], S.annualContractId = Ie == null ? void 0 : Ie.annualContractId;
  }
  function ae() {
    S.boolSysgen && (ce.value.supplierId === S.supplierId ? S.serialNumber = ce.value.serialNumber : S.serialNumber = void 0);
  }
  Ee(() => S.preparationSNList && S.preparationSNList.length > 0);
  const j = Z(), le = Z(/* @__PURE__ */ new Map()), oe = Z([]);
  Ee(() => {
    let Ie = [];
    return j.value ? Ie = le.value.get(j.value) : Ie = oe.value, Ie || [];
  });
  const ye = Z(false);
  Z([]);
  const ce = Z({});
  h.HOOK.afterToAdd = () => {
  }, h.HOOK.afterToCU = () => {
    S.clickTime = (/* @__PURE__ */ new Date()).getTime();
  }, h.HOOK.beforeToCU = () => {
    j.value = void 0, le.value = /* @__PURE__ */ new Map(), oe.value = [];
  }, h.HOOK.beforeToEdit = async (Ie, Se) => {
    ce.value.serialNumber = Se.serialNumber, ce.value.supplierId = Se.supplierId, Array.isArray(Se.preparationList) && Se.preparationList.length > 0 && (await Qt(Se.preparationList), await Ut(Se.preparationList, { toNum: true }), Se.preparationList.forEach((X) => {
      const $ = le.value.get(X.preparationSN);
      $ ? $.push(X) : le.value.set(X.preparationSN, [X]);
      const k = oe.value.findIndex((J) => J.serialNumber === X.serialNumber && J.color === X.color && J.brand === X.brand);
      if (k > -1) oe.value[k].quantity += X.quantity, oe.value[k].mete += X.mete, oe.value[k].preparationSNList.push(X.preparationSN);
      else {
        const J = At(X);
        J.preparationSNList = [X.preparationSN], oe.value.push(J);
      }
    }));
  }, h.HOOK.beforeSubmit = async () => {
    var $;
    if (S.boolDetail = false, S.materialType = void 0, S.list = [], !he()) return false;
    const Ie = [], Se = [];
    if (S.projectId && (!M.edit || M.edit && S.projectId !== S.originEditProjectId) && Se.push(S.projectId), A(S.projectIds) && (!M.edit || M.edit && !el(S.projectIds, S.originEditProjectIds))) for (let k = 0; k < S.projectIds.length; k++) {
      const J = S.projectIds[k];
      (!M.edit || M.edit && !(($ = S.originEditProjectIds) != null && $.includes(J))) && Se.push(J);
    }
    for (let k = 0; k < Se.length; k++) {
      const J = Se[k];
      if (b.value.includes(J) && Ie.findIndex((z) => z.id === J) < 0) {
        const z = V.value.find((F) => F.id === J);
        Ie.push(z);
      }
    }
    let X = true;
    if (A(Ie)) {
      const k = Ie.map((J) => J.name).join("、");
      await zi.confirm(`您已经为《${k}》创建过采购，是否继续创建，请确认?`, "提示", { distinguishCancelAndClose: true, confirmButtonText: "确认", cancelButtonText: "取消" }).then(() => {
        X = true;
      }).catch((J) => {
        X = false;
      });
    }
    return X;
  };
  const se = ft("dataId");
  h.HOOK.afterSubmit = async (Ie) => {
    se.value = null, se.value = await Ie.submitResult.data, y.value = [], c.dispatch("approval_list/fetchTSNum", at.PURCHASE_ORDER_V2.V), c.dispatch("approval_list/fetchSubNum", at.PURCHASE_ORDER_V2.V), c.dispatch("config/fetchSupplyUsedProject"), c.dispatch("config/fetchWmsSuppliers"), r("success");
  }, g.submitFormFormat = (Ie) => (Ie.boolDetail = false, Ie.attachmentIds = Ie.attachments ? Ie.attachments.map((Se) => Se.id) : void 0, Ie.auxMaterialIds = Ie.isAllMaterial ? [0] : Ie.auxMaterialIds, Ie.otherMaterialIds = Ie.isAllOtherMaterial ? [0] : Ie.otherMaterialIds, Ie.projectId && (Ie.projectIds = Array.isArray(Ie.projectId) ? Ie.projectId : [Ie.projectId]), Ie);
  function he() {
    return ye.value ? (ot.warning({ message: "请先“保存”或“取消编辑”分拣信息", duration: 4e3 }), false) : true;
  }
  async function be() {
    var Se;
    let Ie = "";
    g.form.purchaseType === 2 && (Ie = "外委加工合同审批/结算流程（初鸣）"), g.form.purchaseType === 1 && (Ie = "材料合同审批流程（初鸣）"), (Se = M.detail) != null && Se.isGoForOaApproval && await hX({ requestName: Ie, sqr: c.getters.user.oaUserId });
  }
  async function me(Ie) {
    try {
      await be(), S.boolTemporaryStorage = !!Ie, M.isPassedEdit && M.edit && (S.dataStatus === rl.PASSED.V && (g.api = Ic), S.dataStatus === rl.UNDER_APPROVAL.V && (g.api = Cc)), await g.submit();
    } catch (Se) {
      console.log("采购合同提交", Se);
    }
  }
  function ge() {
  }
  function Le() {
  }
  return o({ nextSubmit: ge, submit: me, purchaseType: m, fetchManufList: Le }), (Ie, Se) => {
    const X = Zi, $ = qa, k = Ve("common-select"), J = Mt, z = Fo, F = Ve("common-input-number"), G = Ga, ie = Li;
    return w(), Q("div", null, [C("div", fX, [s(ie, { ref_key: "formRef", ref: E, model: l(S), rules: Y.value, "label-position": "right", "label-width": "110px", size: "default" }, { default: p(() => [C("div", { style: ri(`height: ${e.maxHeight - 280}px;width:980px;`), class: "form-content" }, [s(G, { column: 2, border: "", key: "no-detail", style: { "margin-bottom": "10px" } }, { default: p(() => [s($, { key: "branchCompanyId", "label-class-name": "contractLabel needItem", label: "采购单位" }, { default: p(() => [s(X, { class: "el-form-item-18", label: "", prop: "branchCompanyId", "label-width": "0" }, { default: p(() => [s(M_, { modelValue: l(S).branchCompanyId, "onUpdate:modelValue": Se[0] || (Se[0] = (ue) => l(S).branchCompanyId = ue), disabled: l(S).boolUsed, class: "input-underline", placeholder: "采购单位", style: { width: "100%" }, onCurrentChange: B }, null, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 }), s($, { key: "orderPlace", "label-class-name": "contractLabel needItem", label: "采购目的" }, { default: p(() => [s(X, { class: "el-form-item-18", label: "", prop: "orderPlace", "label-width": "0" }, { default: p(() => [s(k, { modelValue: l(S).orderPlace, "onUpdate:modelValue": Se[1] || (Se[1] = (ue) => l(S).orderPlace = ue), disabled: "", options: l(Bt).ENUM, size: "default", class: "input-underline", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }), s($, { "label-class-name": "contractLabel needItem", label: "关联车间" }, { default: p(() => [l(S).orderPlace === l(Bt).FACTORY.V ? (w(), U(X, { key: 0, class: "el-form-item-18", label: "", prop: "workshopId", "label-width": "0" }, { default: p(() => [s(pu, { modelValue: l(S).workshopId, "onUpdate:modelValue": Se[2] || (Se[2] = (ue) => l(S).workshopId = ue), placeholder: "可选择关联车间", class: "input-underline", clearable: "" }, null, 8, ["modelValue"])]), _: 1 })) : H("", true)]), _: 1 }), s($, { key: "purchaseType", "label-class-name": "contractLabel needItem", label: "采购类型" }, { default: p(() => [s(X, { class: "el-form-item-18", label: "", prop: "purchaseType", "label-width": "0" }, { default: p(() => [s(k, { modelValue: l(S).purchaseType, "onUpdate:modelValue": Se[3] || (Se[3] = (ue) => l(S).purchaseType = ue), disabled: l(S).id && !!l(S).boolUsed, options: l(Fi).ENUM, size: "default", class: "input-underline", type: "enum", onChange: ee }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })]), _: 1 }), l(S).purchaseType !== l(Fi).MANUFACTURED.V ? (w(), U($, { key: "boolAnnual", "label-class-name": "contractLabel needItem", label: "合同类型" }, { default: p(() => [s(X, { class: "el-form-item-18", label: "", prop: "boolAnnual", "label-width": "0" }, { default: p(() => [s(k, { modelValue: l(S).boolAnnual, "onUpdate:modelValue": Se[4] || (Se[4] = (ue) => l(S).boolAnnual = ue), disabled: l(S).id && !!l(S).boolUsed, options: l(Vn).ENUM, size: "default", class: "input-underline", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })]), _: 1 })) : H("", true), s($, { key: "serialNumber", "label-class-name": "contractLabel", label: "采购合同编号" }, { default: p(() => [s(X, { class: "el-form-item-18", label: "", prop: "serialNumber", "label-width": "0" }, { default: p(() => [s(J, { modelValue: l(S).serialNumber, "onUpdate:modelValue": Se[5] || (Se[5] = (ue) => l(S).serialNumber = ue), modelModifiers: { trim: true }, disabled: l(S).boolUsed, class: "input-underline", maxlength: "30", placeholder: "可输入采购合同编号（不填写则自动生成）", size: "default" }, null, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 }), s($, { key: "basicClass", "label-class-name": "contractLabel needItem", label: "物料种类" }, { default: p(() => [s(X, { class: "el-form-item-18", label: "", prop: "basicClass", "label-width": "0" }, { default: p(() => [C("div", gX, [s(cR, { modelValue: l(S).basicClass, "onUpdate:modelValue": Se[6] || (Se[6] = (ue) => l(S).basicClass = ue), disabled: l(S).boolUsed, type: l(S).purchaseType, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择物料种类", style: { flex: "auto" } }, null, 8, ["modelValue", "disabled", "type"])])]), _: 1 })]), _: 1 }), l(S).basicClass & l(Pe).MATERIAL.V ? (w(), U($, { key: "isAllMaterial", "label-class-name": "contractLabel needItem", label: "辅材明细" }, { default: p(() => [l(S).basicClass & l(Pe).MATERIAL.V ? (w(), U(X, { key: 0, class: "el-form-item-5", label: "", "label-width": "0", prop: "auxMaterialIds" }, { default: p(() => [C("div", EX, [s(z, { modelValue: l(S).isAllMaterial, "onUpdate:modelValue": Se[7] || (Se[7] = (ue) => l(S).isAllMaterial = ue), disabled: !!l(S).boolUsed, key: "isAllMaterial", border: "", label: "所有辅材", size: "default", style: { "margin-top": "3px", "margin-right": "5px" } }, null, 8, ["modelValue", "disabled"]), s(Ql, { modelValue: l(S).auxMaterialIds, "onUpdate:modelValue": Se[8] || (Se[8] = (ue) => l(S).auxMaterialIds = ue), "basic-class": l(Pe).MATERIAL.V, "collapse-tags": false, deep: 2, disabled: l(S).boolUsed ? !!l(S).boolUsed : l(S).isAllMaterial, class: "input-underline", clearable: "", isDefaultExpand: "", multiple: "", placeholder: "请选择辅材", separator: " > ", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "disabled"])])]), _: 1 })) : H("", true)]), _: 1 })) : H("", true), l(S).basicClass & l(Pe).OTHER.V ? (w(), U($, { key: "isAllOtherMaterial", "label-class-name": "contractLabel needItem", label: "办公用品" }, { default: p(() => [l(S).basicClass & l(Pe).OTHER.V ? (w(), U(X, { key: 0, class: "el-form-item-18", label: "", prop: "otherMaterialIds", "label-width": "0" }, { default: p(() => [C("div", yX, [s(z, { modelValue: l(S).isAllOtherMaterial, "onUpdate:modelValue": Se[9] || (Se[9] = (ue) => l(S).isAllOtherMaterial = ue), disabled: !!l(S).boolUsed, key: "isAllOtherMaterial", border: "", label: "所有办公用品", size: "default", style: { "margin-top": "3px", "margin-right": "5px" } }, null, 8, ["modelValue", "disabled"]), s(Ql, { modelValue: l(S).otherMaterialIds, "onUpdate:modelValue": Se[10] || (Se[10] = (ue) => l(S).otherMaterialIds = ue), "basic-class": l(Pe).OTHER.V, "collapse-tags": false, deep: 2, disabled: l(S).boolUsed ? !!l(S).boolUsed : l(S).isAllOtherMaterial, class: "input-underline", clearable: "", isDefaultExpand: "", multiple: "", placeholder: "请选择办公用品", separator: " > ", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "disabled"])])]), _: 1 })) : H("", true)]), _: 1 })) : H("", true), s($, { key: "supplierId", "label-class-name": "contractLabel needItem", label: "供应商" }, { default: p(() => [s(X, { class: "el-form-item-18", label: "", prop: "supplierId", "label-width": "0" }, { default: p(() => [s(pd, { modelValue: l(S).supplierId, "onUpdate:modelValue": Se[11] || (Se[11] = (ue) => l(S).supplierId = ue), "basic-class": l(S).basicClass, disabled: l(S).id && !!l(S).boolUsed, isAnnual: l(S).boolAnnual, type: l(S).purchaseType, class: "input-underline", clearable: "", filterable: "", mode: "contain", onChange: ae, onInfoChange: q }, null, 8, ["modelValue", "basic-class", "disabled", "isAnnual", "type"])]), _: 1 })]), _: 1 }), s($, { key: "mete", "label-class-name": "contractLabel needItem", label: "合同量" }, { default: p(() => [s(X, { class: "el-form-item-8", label: "", "label-width": "0", prop: "mete", style: { display: "inline-flex", width: "320px" } }, { default: p(() => [C("div", TX, [s(F, { modelValue: l(S).mete, "onUpdate:modelValue": Se[12] || (Se[12] = (ue) => l(S).mete = ue), controls: false, disabled: l(S).boolUsed, max: 999999999999, step: 1, autocomplete: "off", placeholder: "请填写合同量", style: { width: "100%" } }, null, 8, ["modelValue", "disabled"]), s(uR, { modelValue: l(S).meteUnit, "onUpdate:modelValue": Se[13] || (Se[13] = (ue) => l(S).meteUnit = ue), disabled: l(S).boolUsed, clearable: "", filterable: "", size: "default", style: { width: "80px", flex: "none" } }, null, 8, ["modelValue", "disabled"])])]), _: 1 })]), _: 1 }), s($, { key: "amount", "label-class-name": "contractLabel needItem", label: "合同额" }, { default: p(() => [s(X, { class: "el-form-item-9", label: "", "label-width": "0", prop: "amount", style: { display: "inline-flex", width: "240px" } }, { default: p(() => [C("div", _X, [s(F, { modelValue: l(S).amount, "onUpdate:modelValue": Se[14] || (Se[14] = (ue) => l(S).amount = ue), controls: false, disabled: !!l(S).boolUsed, max: 999999999999, precision: l(Ze).YUAN, step: 1, autocomplete: "off", class: "input-underline", placeholder: "请填写合同额", style: { width: "100%" } }, null, 8, ["modelValue", "disabled", "precision"]), Se[25] || (Se[25] = C("span", null, "元", -1))])]), _: 1 })]), _: 1 }), s($, { key: "invoiceType", "label-class-name": "contractLabel needItem", label: "发票及税率" }, { default: p(() => [s(X, { class: "el-form-item-10", label: "", "label-width": "0", prop: "invoiceType" }, { default: p(() => [s(Xn, { invoiceType: l(S).invoiceType, "onUpdate:invoiceType": Se[15] || (Se[15] = (ue) => l(S).invoiceType = ue), taxRate: l(S).taxRate, "onUpdate:taxRate": Se[16] || (Se[16] = (ue) => l(S).taxRate = ue), classification: l(S).basicClass, disabled: l(S).boolUsed, class: "input-underline" }, null, 8, ["invoiceType", "taxRate", "classification", "disabled"])]), _: 1 })]), _: 1 }), l(S).basicClass & l(ct).STEEL.V ? (w(), U($, { key: "weightMeasurementMode", "label-class-name": "contractLabel needItem", label: "计量方式" }, { default: p(() => [s(X, { class: "el-form-item-11", label: "", "label-width": "0", prop: "weightMeasurementMode" }, { default: p(() => [s(k, { modelValue: l(S).weightMeasurementMode, "onUpdate:modelValue": Se[17] || (Se[17] = (ue) => l(S).weightMeasurementMode = ue), disabled: l(S).boolUsed, options: l(Wt).ENUM, size: "small", class: "input-underline", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })]), _: 1 })) : H("", true), l(S).basicClass & l(ct).STEEL.V ? (w(), U($, { key: "purchaseOrderPaymentMode", "label-class-name": "contractLabel needItem", label: "订单类型" }, { default: p(() => [s(X, { class: "el-form-item-13", label: "", "label-width": "0", prop: "purchaseOrderPaymentMode" }, { default: p(() => [s(k, { modelValue: l(S).purchaseOrderPaymentMode, "onUpdate:modelValue": Se[18] || (Se[18] = (ue) => l(S).purchaseOrderPaymentMode = ue), disabled: l(S).boolUsed, options: l(Jl).ENUM, size: "small", class: "input-underline", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })]), _: 1 })) : H("", true), s($, { key: "logisticsTransportType", "label-class-name": "contractLabel needItem", label: "物流运输方式" }, { default: p(() => [s(X, { class: "el-form-item-16", label: "", "label-width": "0", prop: "logisticsTransportType" }, { default: p(() => [s(k, { modelValue: l(S).logisticsTransportType, "onUpdate:modelValue": Se[19] || (Se[19] = (ue) => l(S).logisticsTransportType = ue), disabled: l(S).boolUsed, options: l(Xa).ENUM, class: "input-underline", size: "default", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })]), _: 1 }), s($, { key: "logisticsPayerType", "label-class-name": "contractLabel needItem", label: "物流费用承担" }, { default: p(() => [s(X, { class: "el-form-item-17", label: "", "label-width": "0", prop: "logisticsPayerType" }, { default: p(() => [s(k, { modelValue: l(S).logisticsPayerType, "onUpdate:modelValue": Se[20] || (Se[20] = (ue) => l(S).logisticsPayerType = ue), disabled: l(S).boolUsed, options: l(Bi).ENUM, class: "input-underline", size: "default", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })]), _: 1 }), l(S).orderPlace === l(Bt).CONSTRUCTION_SITE.V || l(S).purchaseType === l(Fi).MANUFACTURED.V ? (w(), U($, { key: "projectId", "label-class-name": "contractLabel needItem", label: "选择项目" }, { default: p(() => [s(X, { class: "el-form-item-4", label: "", "label-width": "0", prop: "projectId" }, { default: p(() => [s(l(ca), { key: "projectId", modelValue: l(S).projectId, "onUpdate:modelValue": Se[21] || (Se[21] = (ue) => l(S).projectId = ue), branchCompanyId: l(S).branchCompanyId, disabled: l(S).boolUsed ? !!l(S).boolUsed : !l(S).branchCompanyId, projectAttribute: l(S).projectAttribute, class: "input-underline", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" } }, null, 8, ["modelValue", "branchCompanyId", "disabled", "projectAttribute"])]), _: 1 })]), _: 1 })) : (w(), U($, { key: "projectIds", "label-class-name": "contractLabel", label: "选择项目" }, { default: p(() => [s(X, { class: "el-form-item-4", label: "", "label-width": "0", prop: "projectIds" }, { default: p(() => [s(l(ca), { key: "projectIds", modelValue: l(S).projectIds, "onUpdate:modelValue": Se[22] || (Se[22] = (ue) => l(S).projectIds = ue), branchCompanyId: l(S).branchCompanyId, disabled: l(S).boolUsed ? !!l(S).boolUsed : !l(S).branchCompanyId, projectAttribute: l(S).projectAttribute, class: "input-underline", clearable: "", multiple: "", placeholder: "可选择项目搜索", style: { width: "100%" } }, null, 8, ["modelValue", "branchCompanyId", "disabled", "projectAttribute"])]), _: 1 })]), _: 1 })), s($, { key: "remark", "label-class-name": "contractLabel", label: "备注" }, { label: p(() => Se[26] || (Se[26] = [C("span", { class: "el-form-item el-form-item--small" }, [C("span", { class: "el-form-item__label" }, "备注")], -1)])), default: p(() => [s(X, { class: "el-form-item-14", "label-width": "0", prop: "remark" }, { default: p(() => [s(J, { modelValue: l(S).remark, "onUpdate:modelValue": Se[23] || (Se[23] = (ue) => l(S).remark = ue), disabled: !!l(S).boolUsed, rows: 2, maxlength: "1000", placeholder: "备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 })]), _: 1 }), s(dl, { files: l(S).attachments, "onUpdate:files": Se[24] || (Se[24] = (ue) => l(S).attachments = ue), "file-classify": l(cl).PURCHASE_ORDER_ATT.V, showView: true, class: "el-form-item-15", "empty-text": "暂未上传采购合同附件", "show-download": "" }, null, 8, ["files", "file-classify"])], 4)]), _: 1 }, 8, ["model", "rules"])])]);
  };
} }, s3 = ut(bX, [["__scopeId", "data-v-ef949ff9"]]), VX = Object.freeze(Object.defineProperty({ __proto__: null, default: s3 }, Symbol.toStringTag, { value: "Module" }));
const wX = { style: { display: "flex" } }, SX = { key: 0, style: { display: "flex" } }, vX = { style: { display: "flex", "margin-left": "20px" } }, RX = { __name: "index", props: { requisitionList: { type: Array, default: () => [] }, isPassedEdit: { type: Boolean, default: false } }, setup(e) {
  const o = Ht();
  hu(), Zv();
  const { projectAllType: n } = Wa(), { supplyUsedProject: c } = Qv();
  yi("supplyUsedProject", c), yi("projectAllType", n);
  const u = e, r = { boolDetail: false, isGoForOaApproval: true, useRequisitions: true, boolTemporaryStorage: false, serialNumber: void 0, boolAnnual: false, supplyType: Ni.SELF.V, materialType: void 0, purchaseType: Fi.RAW_MATERIAL.V, currentBasicClass: Ge.STEEL_PLATE.V, isAllMaterial: false, auxMaterialIds: void 0, isAllOtherMaterial: false, otherMaterialIds: void 0, projectIds: void 0, projectId: void 0, supplierId: void 0, branchCompanyId: void 0, mete: void 0, meteUnit: "kg", amount: void 0, invoiceType: fi.SPECIAL.V, taxRate: void 0, weightMeasurementMode: Wt.THEORY.V, logisticsTransportType: Xa.FREIGHT.V, logisticsPayerType: Bi.SUPPLIER.V, purchaseOrderPaymentMode: Jl.ARRIVAL.V, projectAttribute: vl.SELF_SUPPORT.V, remark: void 0, attachments: void 0, attachmentIds: void 0, list: [], sectionSteelList: [], steelPlateList: [], steelCoilList: [], originSteelPlateList: [], originSteelCoilList: [], otherSteelMaterialList: [], originSectionSteelList: [], originOtherSteelMaterialList: [], originAuxMatList: [], originGasList: [], originOtherList: [], requisitions: [], requisitionsKV: {}, actualRequisitionIds: [], manufListObj: {}, manufMergeObj: {}, materialTypeTotal: [], orderPlace: void 0, artifactWageQuotaType: ha.WEIGHT.V, enclosureWageQuotaType: ga.LENGTH.V, isFirst: false }, { priceAbnormal: E, purchaseCfg: y } = aa();
  yi("purchaseCfg", y), yi("priceAbnormal", E);
  const b = Z("1080px"), V = Z(), M = Z(), g = Z(false), S = (I) => (I.invoiceSize || I.paymentSize || I.settlementSize) > 0 || (I.settlementAmount || I.cumulativePayment || I.cumulativeInvoice) > 0, h = () => {
    if (_.status.edit > 0) {
      const I = _.data.find((Y) => Y.id === _.form.id);
      g.value = S(I);
    }
  }, { CRUD: T, crud: _, form: f } = An(r, V), m = Ee(() => _.status.cu > T.STATUS.NORMAL), R = Ee(() => _.status.edit > 0);
  Ce([() => m.value, () => u.requisitionList], () => {
    var I, Y, ee, B, q, ae;
    if (m.value) if (b.value = "1080px", A(u.requisitionList)) {
      Ae(o.state.config.getTreeClickTime) && (o.state.config.getTreeClickTime = (/* @__PURE__ */ new Date()).getTime());
      const j = JSON.parse(JSON.stringify(u.requisitionList)), le = [], oe = {};
      j == null || j.map((se) => {
        var he, be;
        se.isRequisition = true, se.projectId = se.projectId || ((he = se.project) == null ? void 0 : he.id), (be = se.detailList) == null || be.forEach((me) => {
          var ge;
          me.isRequisition = true, me.uid = se.id + "_" + me.id + "_" + Tt(), me.projectId = me.projectId || ((ge = me.project) == null ? void 0 : ge.id), me.applyPurchaseDetailId = me.id, le.push(me);
        }), oe[se.id] = { id: se.id, serialNumber: se.serialNumber };
      });
      const ye = [];
      for (let se = 0; se < le.length; se++) {
        ye.includes(le[se].basicClass) || ye.push(le[se].basicClass), le[se].basicClass === Ge.SECTION_STEEL.V && (le[se].standardId = le[se].standardId || ((Y = (I = le[se].nationalStandardOptions) == null ? void 0 : I.find((ge) => ge.boolDefault === true)) == null ? void 0 : Y.standardId));
        const he = le[se];
        he.uid = he.id + "_" + Tt(), he.projectId = he.projectId || ((ee = he.project) == null ? void 0 : ee.id), he.warehouseId = he.warehouseId || ((B = he.warehouse) == null ? void 0 : B.id), he.isFirst = true, he.purchaseSN = (q = oe[he.applyPurchaseId]) == null ? void 0 : q.serialNumber, he.productQuantity = he.productQuantity || 0, he.productMete = he.productMete || 0;
        const be = he.mete, me = he.quantity;
        he.originMete = be, he.originQuantity = me, he.basicClass & ct.MANUFACTURED.V ? he.canPurchaseQuantity = me - he.productQuantity : ((ae = y.value) != null && ae.applyAndProcureMeteDiffState ? he.canPurchaseMete = be * (1 + y.value.applyAndProcureMeteDiff / 100) - he.productMete > 0 ? be * (1 + y.value.applyAndProcureMeteDiff / 100) - he.productMete : 0 : he.canPurchaseMete = be - he.productMete > 0 ? be - he.productMete : 0, he.maxCanPurchaseMete = he.canPurchaseMete, he.basicClass & sl ? (he.purchaseTotalWeight = he.mete, he.weighingTotalWeight = be - he.productMete > 0 ? be - he.productMete : 0) : he.mete = be - he.productMete > 0 ? be - he.productMete : 0);
      }
      let ce;
      for (let se = 0; se < ye.length; se++) ye[se] & sl ? ce = sl : ce = ce ? ce | ye[se] : ye[se];
      pt(async () => {
        var se, he;
        f.boolDetail = true, b.value = "100%", f.isOrigin = true, f.isRequisitionOrigin = true, f.useRequisitions = true, f.actualRequisitionIds = j.map((be) => be.id), f.requisitionsKV = oe, f.list = le, f.originList = JSON.parse(JSON.stringify(le)), f.isRequisition = true, f.materialType = ce, f.projectAttribute = vl.SELF_SUPPORT.V, f.branchCompanyId = u.requisitionList[0].branchCompanyId, f.originBranchCompanyId = f.branchCompanyId, f.branchCompany = u.requisitionList[0].branchCompany, f.orderPlace = u.requisitionList[0].level, f.level = u.requisitionList[0].level, f.steelPlateList = [], f.sectionSteelList = [], f.steelCoilList = [], f.otherSteelMaterialList = [], f.auxiliaryMaterialList = [], f.otherList = [], f.gasList = [], f.project = [], f.purchaseType = f.materialType & ct.MANUFACTURED.V ? Fi.MANUFACTURED.V : Fi.RAW_MATERIAL.V, f.materialType & ct.MANUFACTURED.V ? (f.structureList = [], f.enclosureList = [], f.projectId = le == null ? void 0 : le[0].projectId, f.projects = (se = le == null ? void 0 : le[0]) != null && se.projectId ? [le == null ? void 0 : le[0].project] : [], f.originProjectId = f.projectId) : (f.level === Bt.CONSTRUCTION_SITE.V && (f.projectId = le == null ? void 0 : le[0].projectId, f.projects = (he = le == null ? void 0 : le[0]) != null && he.projectId ? [le == null ? void 0 : le[0].project] : [], f.originProjectId = f.projectId), le.forEach((be) => {
          var me, ge, Le, Ie, Se, X, $;
          switch (f.orderPlace === Bt.CONSTRUCTION_SITE.V && f.project.find((k) => k.id === be.projectId) < 0 && f.project.push(be.project), be.weighingTotalWeight = be.mete, be.specificationMap = be.specKV, be.basicClass) {
            case Pe.STEEL_PLATE.V:
              be.workshopId = ((me = f.steelPlateList) == null ? void 0 : me.length) > 0 ? -1 : void 0, be.weightMeasurementMode = Wt.THEORY.V, f.steelPlateList.push(be), f.originSteelPlateList.push(be);
              break;
            case Pe.SECTION_STEEL.V:
              be.workshopId = ((ge = f.sectionSteelList) == null ? void 0 : ge.length) > 0 ? -1 : void 0, be.weightMeasurementMode = Wt.THEORY.V, f.sectionSteelList.push(be), f.originSectionSteelList.push(be);
              break;
            case Pe.STEEL_COIL.V:
              be.workshopId = ((Le = f.steelCoilList) == null ? void 0 : Le.length) > 0 ? -1 : void 0, f.steelCoilList.push(be), f.originSteelCoilList.push(be);
              break;
            case Pe.OTHER_STEEL_MATERIALS.V:
              be.workshopId = ((Ie = f.otherSteelMaterialList) == null ? void 0 : Ie.length) > 0 ? -1 : void 0, f.otherSteelMaterialList.push(be), f.originOtherSteelMaterialList.push(be);
              break;
            case Pe.MATERIAL.V:
              be.workshopId = ((Se = f.auxiliaryMaterialList) == null ? void 0 : Se.length) > 0 ? -1 : void 0, f.auxiliaryMaterialList.push(be), f.originAuxMatList.push(be);
              break;
            case Pe.GAS.V:
              be.workshopId = ((X = f.gasList) == null ? void 0 : X.length) > 0 ? -1 : void 0, f.gasList.push(be), f.originGasList.push(be);
              break;
            case Pe.OTHER.V:
              be.workshopId = (($ = f.otherList) == null ? void 0 : $.length) > 0 ? -1 : void 0, f.otherList.push(be), f.originOtherList.push(be);
              break;
          }
        })), f.materialTypeTotal = Ra.getBits(ct.ENUM, f.materialType, "V"), A(f.materialTypeTotal) && (f.materialTypeTotal.includes(ct.STEEL.V) ? f.currentBasicClass = Pe.STEEL_PLATE.V : f.materialTypeTotal.includes(ct.MANUFACTURED.V) ? (f.currentMaterial = ct.MANUFACTURED.V, f.currentBasicClass = Pe.STRUC_MANUFACTURED.V) : f.materialTypeTotal.includes(ct.MATERIAL.V) ? (f.currentMaterial = ct.MATERIAL.V, f.currentBasicClass = Pe.MATERIAL.V) : f.materialTypeTotal.includes(ct.OTHER.V) ? (f.currentMaterial = ct.OTHER.V, f.currentBasicClass = Pe.OTHER.V) : (f.currentMaterial = ct.GAS.V, f.currentBasicClass = Pe.GAS.V)), f.isFirst = true;
      });
    } else f.id || (f.boolDetail = A(y.value.boolHaveDetail) ? y.value.boolHaveDetail : false, pt(() => {
      f.boolDetail === ea.TRUE.V ? (b.value = "100%", f.materialType = void 0) : (b.value = "1080px", f.materialType = void 0);
    }));
  }, { immediate: true, deep: true });
  function v(I) {
    b.value = I ? "100%" : "1080px";
  }
  function N(I) {
    f.isGoForOaApproval = I, console.log(f.isGoForOaApproval, f, f.purchaseType, I, "val111");
  }
  const P = Ee(() => {
    switch (f.boolDetail) {
      case ea.TRUE.V:
        return n3;
      default:
        return s3;
    }
  }), { maxHeight: L } = Kt({ mainBox: ".purchase-order-raw-mat-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true }, m);
  cn(), T.HOOK.afterToAdd = () => {
    setTimeout(() => {
    }, 300);
  }, T.HOOK.beforeEditDetailLoaded = async (I) => {
    var B, q, ae, j, le;
    f.isGoForOaApproval = true, b.value = "1080px", f.actualRequisitionIds = [], f.requisitions = [], A(f.projects) && (f.projectIds = f.projects.map((oe) => oe.id), f.originEditProjectIds = JSON.parse(JSON.stringify(f.projectIds)), (f.level === Bt.CONSTRUCTION_SITE.V || f.materialType & ct.MANUFACTURED.V) && (f.projectId = f.projectIds[0], f.originEditId = f.projectId)), f.boolAnnual = !!f.boolAnnual, Ae(f.attachments) && (f.attachments = []);
    let Y = {};
    if (A(f.applyPurchase)) {
      (B = f.applyPurchase) == null || B.forEach((ye) => {
        ye.id && (f.actualRequisitionIds.push(ye.id), f.requisitions.push(ye));
      }), Y = Uo(f.applyPurchase), f.requisitionsKV = Y;
      const oe = f.applyPurchaseStatus ? JSON.parse(f.applyPurchaseStatus) : [];
      oe == null || oe.forEach((ye) => {
        A(f.requisitionsKV) && f.requisitionsKV[ye.id];
      });
    }
    f.requisitionsKV = A(f.requisitionsKV) ? f.requisitionsKV : {}, f.isAllMaterial = (q = f.auxMaterialIds) == null ? void 0 : q.includes(0), f.isAllOtherMaterial = (ae = f.otherMaterialIds) == null ? void 0 : ae.includes(0), f.isAllGAS = (j = f.gasMaterialIds) == null ? void 0 : j.includes(0), f.branchCompanyId = f.branchCompany ? f.branchCompany.id : void 0, f.supplierId = f.supplier ? f.supplier.id : void 0, f.workshopId = (le = f.mesWorkshop) == null ? void 0 : le.id, f.clickTime = (/* @__PURE__ */ new Date()).getTime();
    const ee = [];
    if (A(f.details)) {
      await o.dispatch("wms/fetchSteelDensityCfg");
      const oe = [];
      if (f.materialType & ct.MANUFACTURED.V) {
        await Qt(f.details), await fo(f.details, { toNum: true }, { mete: ["mete", "applyPurchaseMete", "canPurchaseMete"] });
        const ye = [];
        f.list = f.details.map((ce) => {
          var se, he;
          if (ce.isFirst = true, ce.uid = ce.id, ce.originId = ce.id, ce.purchaseSN = (se = Y[ce.applyPurchaseId]) == null ? void 0 : se.serialNumber, ce.originPurchaseQuantity = ce.quantity, ce.applyPurchaseDetailId) {
            ee.includes(ce.applyPurchaseDetailId) || ee.push(ce.applyPurchaseDetailId);
            const be = ((he = f.detailQuantityAndMetes) == null ? void 0 : he.find((me) => me.id === ce.applyPurchaseDetailId)) || {};
            ce.canPurchaseQuantity = ce.applyPurchaseQuantity - ce.productQuantity + ((be == null ? void 0 : be.quantity) || 0);
          }
          return ye.findIndex((be) => be.basicClass === ce.basicClass && be.finishedGoodsTypeName === ce.finishedGoodsTypeName) < 0 && ye.push({ basicClass: ce.basicClass, finishedGoodsTypeName: ce.finishedGoodsTypeName }), ce;
        }), f.structureList = [], f.enclosureList = [], ye.forEach((ce) => {
          const se = f.details.filter((he) => he.basicClass === ce.basicClass && he.finishedGoodsTypeName === ce.finishedGoodsTypeName);
          if (A(se)) {
            let he = 0, be = 0, me = 0, ge = 0, Le = 0;
            se.forEach((Ie) => {
              he += Ie.quantity || 0, be += Ie.totalWeight || 0, me += Ie.totalLength || 0, ge += Ie.totalArea || 0, Le += Ie.amount || 0;
            }), ce.basicClass === Pe.STRUC_MANUFACTURED.V ? f.structureList.push({ basicClass: ce.basicClass, boolOriginalDetail: se.findIndex((Ie) => Ie.boolOriginalDetail) > -1 ? !!f.boolUsed : false, finishedGoodsTypeName: ce.finishedGoodsTypeName, manufacturedSpecification: se[0].manufacturedSpecification, wageQuotaType: se[0].wageQuotaType, quantity: he, totalWeight: be, totalLength: me, manufacturedUnit: se[0].wageQuotaType === ha.WEIGHT.V ? "吨" : "米", unitPrice: se[0].unitPrice, amount: Le, listId: se.map((Ie) => Ie.applyPurchaseDetailId) || [], list: se }) : f.enclosureList.push({ basicClass: ce.basicClass, boolOriginalDetail: se.findIndex((Ie) => Ie.boolOriginalDetail) > -1 ? !!f.boolUsed : false, finishedGoodsTypeName: ce.finishedGoodsTypeName, manufacturedSpecification: se[0].manufacturedSpecification, wageQuotaType: se[0].wageQuotaType, quantity: he, manufacturedType: se[0].manufacturedType, manufacturedUnit: se[0].wageQuotaType === ga.LENGTH.V ? "米" : "平方米", unitPrice: se[0].unitPrice, amount: Le, totalWeight: be, totalLength: me, totalArea: ge, listId: se.map((Ie) => Ie.applyPurchaseDetailId) || [], list: se });
          }
        });
      } else f.delDetailIds = [], f.details.forEach((ye) => {
        ye.classifyId && !oe.includes(ye.classifyId) && oe.push(ye.classifyId);
      }), A(f.detailQuantityAndMetes) && f.detailQuantityAndMetes.forEach((ye) => {
        ye.classifyId && !oe.includes(ye.classifyId) && oe.push(ye.classifyId);
      }), await E_(oe), await Qt(f.details), await Ut(f.details, { toNum: true }, { mete: ["mete", "applyPurchaseMete", "canPurchaseMete", "productMete"] }), A(f.detailQuantityAndMetes) && (await Qt(f.detailQuantityAndMetes), await Ut(f.detailQuantityAndMetes, { toNum: true }, { mete: ["mete"] })), f.list = f.details.map((ye) => {
        var ce, se, he;
        if (ye.isFirst = true, ye.uid = ye.id, ye.purchaseSN = (ce = Y[ye.applyPurchaseId]) == null ? void 0 : ce.serialNumber, ye.purchaseTotalWeight = ye.applyPurchaseMete, ye.originPurchaseMete = ye.mete, ye.originPurchaseQuantity = ye.quantity, ye.applyPurchaseDetailId) {
          ee.includes(ye.applyPurchaseDetailId) || ee.push(ye.applyPurchaseDetailId);
          const be = ((se = f.detailQuantityAndMetes) == null ? void 0 : se.find((me) => me.id === ye.applyPurchaseDetailId)) || {};
          (he = y.value) != null && he.applyAndProcureMeteDiffState ? ye.canPurchaseMete = ye.applyPurchaseMete * (1 + y.value.applyAndProcureMeteDiff / 100) - ye.productMete > 0 ? ye.applyPurchaseMete * (1 + y.value.applyAndProcureMeteDiff / 100) - ye.productMete : 0 : ye.canPurchaseMete = ye.applyPurchaseMete - ye.productMete > 0 ? ye.applyPurchaseMete - ye.productMete : 0, ye.maxCanPurchaseMete = ye.canPurchaseMete + ((be == null ? void 0 : be.mete) || 0);
        }
        return ye.originDetailObj = f.boolUsed ? JSON.parse(JSON.stringify(ye)) : {}, ye;
      }), await Xr(f), f.materialType & ct.MANUFACTURED.V || (f.originSteelPlateList = f.steelPlateList, f.originSectionSteelList = f.sectionSteelList, f.originSteelCoilList = f.steelCoilList, f.originOtherSteelMaterialList = f.otherSteelMaterialList, f.originAuxMatList = f.auxiliaryMaterialList, f.originGasList = f.gasList, f.originOtherList = f.otherList);
      f.materialTypeTotal = Ra.getBits(ct.ENUM, f.materialType, "V"), A(f.materialTypeTotal) && (f.materialTypeTotal.includes(ct.STEEL.V) ? f.currentBasicClass = Pe.STEEL_PLATE.V : f.materialTypeTotal.includes(ct.MANUFACTURED.V) ? (f.currentMaterial = ct.MANUFACTURED.V, f.currentBasicClass = Pe.STRUC_MANUFACTURED.V) : f.materialTypeTotal.includes(ct.MATERIAL.V) ? (f.currentMaterial = ct.MATERIAL.V, f.currentBasicClass = Pe.MATERIAL.V) : f.materialTypeTotal.includes(ct.OTHER.V) ? (f.currentMaterial = ct.OTHER.V, f.currentBasicClass = Pe.OTHER.V) : (f.currentMaterial = ct.GAS.V, f.currentBasicClass = Pe.GAS.V)), f.isFirst = true, f.originDetailList = JSON.parse(JSON.stringify(f.list)), f.oriquisitionArr = f.details.filter((ye) => ye.boolOriginalDetail && ye.applyPurchaseId) || [], pt(() => {
        var ye;
        (ye = M.value) == null || ye.fetchManufList();
      });
    } else f.boolDetail && (f.materialTypeTotal = Ra.getBits(ct.ENUM, f.materialType, "V"), f.list = [], f.steelPlateList = [], f.sectionSteelList = [], f.steelCoilList = [], f.otherSteelMaterialList = [], f.auxiliaryMaterialList = [], f.otherList = [], f.gasList = [], f.structureList = [], f.enclosureList = [], f.originSteelPlateList = f.steelPlateList, f.originSectionSteelList = f.sectionSteelList, f.originSteelCoilList = f.steelCoilList, f.originOtherSteelMaterialList = f.otherSteelMaterialList, f.originAuxMatList = f.auxiliaryMaterialList, f.originGasList = f.gasList, f.originOtherList = f.otherList);
    f.boolDetail ? b.value = "100%" : b.value = "1080px";
  };
  function O(I) {
    f.materialType = I;
  }
  async function x() {
    b.value = f.boolDetail ? "100%" : "1080px", _.cancelCU(), _.cancelDetail(), _.refresh(), o.dispatch("approval_list/fetchTSNum", at.PURCHASE_ORDER_V2.V), o.dispatch("approval_list/fetchApprovalNum");
  }
  return (I, Y) => {
    const ee = Ve("common-radio"), B = Ve("common-button"), q = Ve("common-drawer");
    return w(), U(q, { ref: "drawerRef", "before-close": l(_).cancelCU, "close-on-click-modal": false, contentLoading: l(_).editDetailLoading, "show-close": true, size: b.value, title: R.value ? "编辑采购订单（自营）" : "新增采购订单（自营）", visible: m.value, "custom-class": "purchase-order-raw-mat-form", "destroy-on-close": "", onOpen: h }, { titleAfter: p(() => [C("div", wX, [R.value ? H("", true) : (w(), Q("div", SX, [Y[4] || (Y[4] = C("div", { style: { "font-weight": "700", "font-size": "14px", width: "110px", "line-height": "32px" } }, [C("span", { style: { color: "#f56c6c", "font-weight": "normal", "margin-right": "4px" } }, "*"), Te(" 是否有明细 ")], -1)), s(ee, { modelValue: l(f).boolDetail, "onUpdate:modelValue": Y[0] || (Y[0] = (ae) => l(f).boolDetail = ae), options: l(ea).ENUM, type: "enum", onChange: v }, null, 8, ["modelValue", "options"])])), C("div", vX, [Y[5] || (Y[5] = C("div", { style: { "font-weight": "700", "font-size": "14px", width: "110px", "line-height": "32px" } }, [C("span", { style: { color: "#f56c6c", "font-weight": "normal", "margin-right": "4px" } }, "*"), Te(" 是否走OA ")], -1)), s(ee, { modelValue: l(f).isGoForOaApproval, "onUpdate:modelValue": Y[1] || (Y[1] = (ae) => l(f).isGoForOaApproval = ae), options: l(ea).ENUM, type: "enum", onChange: N }, null, 8, ["modelValue", "options"])])])]), titleRight: p(() => {
      var ae, j;
      return [l(f).boolDetail ? (w(), U(B, { key: 0, size: "default", type: "primary", onClick: (ae = M.value) == null ? void 0 : ae.nextSubmit }, { default: p(() => Y[6] || (Y[6] = [Te(" 下一步 ")])), _: 1, __: [6] }, 8, ["onClick"])) : H("", true), l(f).boolDetail ? H("", true) : (w(), U(B, { key: 1, size: "default", type: "primary", onClick: Y[2] || (Y[2] = (le) => M.value.submit(l(co).NO.V)) }, { default: p(() => Y[7] || (Y[7] = [Te(" 预 览 ")])), _: 1, __: [7] })), (!R.value || R.value && l(f).boolTemporaryStorage === l(co).YES.V) && ((j = M.value) == null ? void 0 : j.purchaseType) === l(Fi).RAW_MATERIAL.V ? (w(), U(B, { key: 2, size: "default", type: "warning", onClick: Y[3] || (Y[3] = (le) => M.value.submit(l(co).YES.V)) }, { default: p(() => Y[8] || (Y[8] = [Te(" 暂 存 ")])), _: 1, __: [8] })) : H("", true)];
    }), content: p(() => [C("div", null, [l(_).status.cu > l(T).STATUS.NORMAL ? (w(), U(Ri(P.value), { key: 0, ref_key: "compRef", ref: M, detail: l(f), dialogVisible: m.value, edit: R.value, "is-passed-edit": u.isPassedEdit, maxHeight: l(L) - 50, onMaterTypeToalChange: O, requisitionList: e.requisitionList, onSuccess: x }, null, 40, ["detail", "dialogVisible", "edit", "is-passed-edit", "maxHeight", "requisitionList"])) : H("", true)])]), _: 1 }, 8, ["before-close", "contentLoading", "size", "title", "visible"]);
  };
} }, r3 = ut(RX, [["__scopeId", "data-v-dd87ae48"]]), MX = Object.freeze(Object.defineProperty({ __proto__: null, default: r3 }, Symbol.toStringTag, { value: "Module" }));
function AX(e) {
  return W({ url: "/api/v2/wms/inbound/application/selfBuyingSteel", method: "post", data: e });
}
function NX(e) {
  let o = "", n = "";
  return e != null && e.id ? (o = "/api/v2/wms/inbound/application/record/raw-materials", n = "put") : (o = "/api/wms/begin/inbound/application/selfBuyingSteel", n = "post"), W({ url: o, method: n, data: e });
}
function LX(e) {
  return W({ url: "/api/v2/wms/inbound/application/selfBuying/auxiliary-material", method: "post", data: e });
}
function IX(e) {
  let o = "", n = "";
  return e != null && e.id ? (o = "/api/v2/wms/inbound/application/record/raw-materials", n = "put") : (o = "/api/wms/begin/inbound/application/selfBuying/auxiliary-material", n = "post"), W({ url: o, method: n, data: e });
}
function CX(e) {
  return W({ url: "/api/v2/wms/inbound/application/selfBuying/other-material", method: "post", data: e });
}
function u3(e) {
  let o = "", n = "";
  return e != null && e.id ? (o = "/api/v2/wms/inbound/application/record/raw-materials", n = "put") : (o = "/api/wms/begin/inbound/application/selfBuying/other-material", n = "post"), W({ url: o, method: n, data: e });
}
