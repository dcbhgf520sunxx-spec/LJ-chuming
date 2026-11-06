async function id() {
  const e = wA();
  return Ae(e) && await _e.dispatch("wms/fetchWmsConfig"), e;
}
async function Ut(e, { basicClass: o, measureUnit: n, accountingUnit: c, accountingPrecision: u, measurePrecision: r, prefix: E, newObj: y = false, toNum: b = false, showUnit: V = false, toSmallest: M = false } = {}, g) {
  const S = await _a(), h = await du();
  let T = o;
  const _ = (f) => {
    if (Ae(f)) return;
    o || (T = f.basicClass);
    const m = y ? At(f) : f;
    return T <= ua && E7(m, S, { basicClass: T, toNum: b, showUnit: V, toSmallest: M }, g), y7(m, h, { basicClass: T, measureUnit: A(n) ? n : m.measureUnit, accountingUnit: A(c) ? c : m.accountingUnit, accountingPrecision: A(u) ? u : m.accountingPrecision, measurePrecision: A(r) ? r : m.measurePrecision, toNum: b, showUnit: V, toSmallest: M }, g), m;
  };
  return Array.isArray(e) ? e.map((f) => _(E ? f[E] : f)) : _(E ? e[E] : e);
}
function E7(e, o, { basicClass: n, toNum: c = false, showUnit: u = false, toSmallest: r = false } = {}, { length: E = ["length", "totalLength"], width: y = ["width"], weight: b = ["weight", "totalWeight"], thickness: V = ["thickness"] } = {}) {
  if (!n || !o[n]) return e;
  if (E && E instanceof Array) {
    const M = r ? o[n].length.unit : Ft.LENGTH, g = r ? Ft.LENGTH : o[n].length.unit, S = r ? Ft.LENGTH_DP : o[n].length.precision;
    E.forEach((h) => {
      $o.test(e[h]) && (e[h] = St(e[h], M, g, S, { showUnit: u, toNum: c }));
    });
  }
  if (y && y instanceof Array) {
    const M = r ? o[n].width.unit : Ft.LENGTH, g = r ? Ft.LENGTH : o[n].width.unit, S = r ? Ft.LENGTH_DP : o[n].width.precision;
    y.forEach((h) => {
      $o.test(e[h]) && (e[h] = St(e[h], M, g, S, { showUnit: u, toNum: c }));
    });
  }
  if (b && b instanceof Array) {
    const M = r ? o[n].weight.unit : Ft.WEIGHT, g = r ? Ft.WEIGHT : o[n].weight.unit, S = r ? Ft.WEIGHT_DP : o[n].weight.precision;
    b.forEach((h) => {
      $o.test(e[h]) && (e[h] = St(e[h], M, g, S, { showUnit: u, toNum: c }));
    });
  }
  if (V && V instanceof Array && o[n].thickness) {
    const M = r ? o[n].thickness.unit : Ft.THICKNESS, g = r ? Ft.THICKNESS : o[n].thickness.unit, S = r ? Ft.THICKNESS_DP : o[n].thickness.precision;
    V.forEach((h) => {
      $o.test(e[h]) && (e[h] = St(e[h], M, g, S, { showUnit: u, toNum: c }));
    });
  }
}
function y7(e, o, { basicClass: n, measureUnit: c, measurePrecision: u, accountingUnit: r, accountingPrecision: E, toNum: y = false, showUnit: b = false, toSmallest: V = false } = {}, { unitNetCalcMete: M = "mete", unitNetCalcQuantity: g = "quantity", mete: S = ["mete", "frozenMete"], quantity: h = ["quantity", "frozenQuantity"], unitNet: T = "unitNet", accountingUnitNet: _ = "accountingUnitNet", amount: f = ["unitPrice", "unitPriceExcludingVAT"] } = {}) {
  const m = o.get(c), R = o.get(r);
  A(c) && Ae(m) && console.error(`“${c}”:无法从当前系统获取当该单位配置`), A(r) && Ae(R) && console.error(`“${r}”:无法从当前系统获取当该单位配置`), Ae(e.unitNet) && (e.unitNet = e[g] ? ji(e[M] / e[g], tm) : void 0), A(m) && A(h) && tr({ data: e, fields: h, symbol: m.symbol, unitPrecision: u, type: m.type, toSmallest: V, showUnit: b, toNum: y }), A(R) && (A(S) && tr({ data: e, fields: S, symbol: R.symbol, unitPrecision: E, type: R.type, toSmallest: V, showUnit: b, toNum: y }), A(f) && tr({ data: e, fields: f, symbol: R.symbol, unitPrecision: 10, type: R.type, toSmallest: !V, boolPrice: true, showUnit: b, toNum: y }), T7({ data: e, unitNet: T, accountingUnitNet: _, measureUnit: m, accountingUnit: R, measurePrecision: u, accountingPrecision: E, toSmallest: V, showUnit: b, toNum: y }));
}
function T7({ data: e, unitNet: o = "unitNet", accountingUnitNet: n = "accountingUnitNet", measureUnit: c, accountingUnit: u, measurePrecision: r, accountingPrecision: E, toSmallest: y, showUnit: b, toNum: V }) {
  if (!Ae(o)) if (A(c)) {
    const M = sm(c.type), g = St(1, c.symbol, Ft[M], Ft[`${M}_DP`], { showUnit: b, toNum: V }), S = sm(u.type), T = St(1, u.symbol, Ft[S], Ft[`${S}_DP`], { showUnit: b, toNum: V }) / g;
    if ($o.test(e[o])) {
      const _ = y ? e[o] * T : e[o] / T;
      e[o] = Be(_, tm), e[n] = Be(1 / _, tm);
    }
  } else e[o] = 1, e[n] = 1;
}
function tr({ data: e, fields: o, symbol: n, unitPrecision: c, type: u, toSmallest: r, showUnit: E, toNum: y, boolPrice: b = false }) {
  const V = sm(u);
  if (u && n) {
    const M = r ? n : Ft[V], g = r ? Ft[V] : n, S = r && !b ? Ft[`${V}_DP`] : c;
    o.forEach((h) => {
      e[h] = R2(e[h]), $o.test(e[h]) && (e[h] = St(e[h], M, g, S, { showUnit: E, toNum: y }));
    });
  } else o.forEach((M) => {
    e[M] = R2(e[M]), $o.test(e[M]) && (e[M] = ji(e[M], c, { toNum: y }));
  });
}
async function Krt(e = [], { fields: o, unitField: n = "unit", unitPrecisionField: c = "unitPrecision", toSmallest: u = false, showUnit: r = false, toNum: E = false } = {}) {
  const y = await du();
  e.forEach((b) => yS(b, { unit: y.get(b[n]), precision: b[c], fields: o, toSmallest: u, showUnit: r, toNum: E }));
}
async function Wrt(e, { unit: o, precision: n = 0, fields: c, toSmallest: u = false, showUnit: r = false, toNum: E = false } = {}) {
  const y = await du();
  yS(e, { unit: y.get(o), precision: n, fields: c, toSmallest: u, showUnit: r, toNum: E });
}
function yS(e, { unit: o, precision: n = 0, fields: c, toSmallest: u = false, showUnit: r = false, toNum: E = false } = {}) {
  Ae(o) || Ae(c) || tr({ data: e, fields: c, symbol: o.symbol, unitPrecision: n, type: o.type, toSmallest: u, showUnit: r, toNum: E });
}
function sm(e) {
  switch (e) {
    case Ka.WEIGHT.V:
      return "WEIGHT";
    case Ka.LENGTH.V:
      return "LENGTH";
    case Ka.AREA.V:
      return "AREA";
    case Ka.VOLUME.V:
      return "VOLUME";
  }
}
async function fo(e, { basicClass: o, measureUnit: n, accountingUnit: c, accountingPrecision: u, measurePrecision: r, prefix: E, newObj: y = false, toNum: b = false, showUnit: V = false, toSmallest: M = false } = {}, g) {
  let S = o;
  const h = (T) => {
    if (Ae(T)) return;
    o || (S = T.basicClass);
    const _ = y ? At(T) : T;
    return _7(_, vi, { basicClass: S, toNum: b, showUnit: V, toSmallest: M }, g), b7(_, vi[S], { basicClass: S, measureUnit: A(n) ? n : _.measureUnit, accountingUnit: A(c) ? c : _.accountingUnit, accountingPrecision: A(u) ? u : _.accountingPrecision, measurePrecision: A(r) ? r : _.measurePrecision, toNum: b, showUnit: V, toSmallest: M }, g), _;
  };
  return Array.isArray(e) ? e.map((T) => h(E ? T[E] : T)) : h(E ? e[E] : e);
}
function _7(e, o, { basicClass: n, toNum: c = false, showUnit: u = false, toSmallest: r = false } = {}, { length: E = ["totalLength"], area: y = ["totalArea"], weight: b = ["weight", "totalWeight"] } = {}) {
  if (!n || !o[n]) return e;
  if (E && E instanceof Array) {
    const V = r ? o[n].length.unit : Ft.LENGTH, M = r ? Ft.LENGTH : o[n].length.unit, g = r ? Ft.LENGTH_DP : o[n].length.precision;
    E.forEach((S) => {
      $o.test(e[S]) && (e[S] = St(e[S], V, M, g, { showUnit: u, toNum: c }));
    });
  }
  if (b && b instanceof Array) {
    const V = r ? o[n].showWeight.unit : Ft.WEIGHT, M = r ? Ft.WEIGHT : o[n].showWeight.unit, g = r ? Ft.WEIGHT_DP : o[n].showWeight.precision;
    V && M && b.forEach((S) => {
      $o.test(e[S]) && (e[S] = St(e[S], V, M, g, { showUnit: u, toNum: c }));
    });
  }
  if (y && y instanceof Array && o[n].area) {
    const V = r ? o[n].area.unit : Ft.AREA, M = r ? Ft.AREA : o[n].area.unit, g = r ? Ft.AREA_DP : o[n].area.precision;
    y.forEach((S) => {
      $o.test(e[S]) && (e[S] = St(e[S], V, M, g, { showUnit: u, toNum: c }));
    });
  }
}
function b7(e, o, { basicClass: n, measureUnit: c, measurePrecision: u, accountingUnit: r, accountingPrecision: E, toNum: y = false, showUnit: b = false, toSmallest: V = false } = {}, { unitNetCalcMete: M = "mete", unitNetCalcQuantity: g = "quantity", mete: S = ["mete"], quantity: h = ["quantity"], unitNet: T = "unitNet", accountingUnitNet: _ = "accountingUnitNet", amount: f = ["unitPrice", "unitPriceExcludingVat", "unitPriceExcludingVAT"] } = {}) {
  const m = e.basicClass === Ge.STRUC_MANUFACTURED.V ? e.wageQuotaType === Gi.WEIGHT.V ? o == null ? void 0 : o.weight : e.wageQuotaType === Gi.LENGTH.V ? o == null ? void 0 : o.length : o == null ? void 0 : o.quantity : e.wageQuotaType === Gi.LENGTH.V ? o == null ? void 0 : o.length : e.wageQuotaType === Gi.AREA.V ? o == null ? void 0 : o.area : o == null ? void 0 : o.quantity;
  A(r) && Ae(m) && console.error(`“${r}”:无法从当前系统获取当该单位配置`), A(m) && (A(S) && tr({ data: e, fields: S, symbol: m.symbol, unitPrecision: E, type: m.type, toSmallest: V, showUnit: b, toNum: y }), A(f) && tr({ data: e, fields: f, symbol: m.symbol, unitPrecision: 10, type: m.type, toSmallest: !V, boolPrice: true, showUnit: b, toNum: y }));
}
function Ki(e) {
  let o = Un();
  switch (Ae(o) && (_e.dispatch("wms/fetchWmsConfig"), o = Un()), e.basicClass) {
    case Ge.STEEL_PLATE.V:
      return V7(e, o);
    case Ge.SECTION_STEEL.V:
      return w7(e, o);
    case Ge.STEEL_COIL.V:
      return S7(e, o);
    case Ge.MATERIAL.V:
      return v7(e);
    case Ge.OTHER.V:
      return R7(e);
    case Ge.GAS.V:
      return M7(e);
    case Ge.STRUC_MANUFACTURED.V:
      return A7(e);
    case Ge.ENCL_MANUFACTURED.V:
      return N7(e);
    case Pe.OTHER_STEEL_MATERIALS.V:
      return L7(e);
    default:
      return e.spec;
  }
}
function Ma(e) {
  let o = Un();
  Ae(o) && (_e.dispatch("wms/fetchWmsConfig"), o = Un());
  let n = "";
  switch (e.basicClass) {
    case Ge.STEEL_PLATE.V:
      n = I7(e, o);
      break;
    case Ge.SECTION_STEEL.V:
      n = C7(e, o);
      break;
    case Ge.STEEL_COIL.V:
      n = P7(e, o);
      break;
    case Ge.MATERIAL.V:
      n = O7(e);
      break;
    case Ge.OTHER.V:
      n = k7(e);
      break;
    case Ge.GAS.V:
      n = D7(e);
      break;
    case Ge.STRUC_MANUFACTURED.V:
      n = x7();
      break;
    case Ge.ENCL_MANUFACTURED.V:
      n = U7(e);
      break;
    default:
      n = e.specificationLabels;
      break;
  }
  return n || "无规格";
}
function V7(e, o) {
  const n = [], c = [];
  return A(e.thickness) && !isNaN(e.thickness) && c.push(Number(e.thickness)), A(e.width) && !isNaN(e.width) && c.push(e.width), A(e.length) && !isNaN(e.length) && c.push(e.length), A(c) && n.push(c.join("*")), o === mo.LEFT_SPEC.V ? A(e.specification) && n.unshift(e.specification) : A(e.specification) && n.push(e.specification), n.join(" * ");
}
function w7(e, o) {
  const n = [];
  return A(e.length) && !isNaN(e.length) && n.push(e.length), o === mo.LEFT_SPEC.V ? A(e.specification) && e.specificationLabels !== "无规格" && n.unshift(e.specification) : A(e.specification) && e.specificationLabels !== "无规格" && n.push(e.specification), n.join(" * ");
}
function S7(e, o) {
  const n = [], c = [];
  return A(e.thickness) && !isNaN(e.thickness) && c.push(Number(e.thickness)), A(e.width) && !isNaN(e.width) && c.push(e.width), A(e.length) && !isNaN(e.length) && c.push(e.length), A(c) && n.push(c.join("*")), o === mo.LEFT_SPEC.V ? A(e.specification) && e.specificationLabels !== "无规格" && n.unshift(e.specification) : A(e.specification) && e.specificationLabels !== "无规格" && n.push(e.specification), A(e.color) && n.push(e.color), n.join(" * ");
}
function v7(e) {
  const o = [];
  return A(e.specification) && e.specificationLabels !== "无规格" && o.push(e.specification), A(e.color) && o.push(e.color), o.join(" * ");
}
function R7(e) {
  const o = [];
  return A(e.specification) && e.specificationLabels !== "无规格" && o.push(e.specification), A(e.color) && o.push(e.color), o.join(" * ");
}
function M7(e) {
  const o = [];
  return A(e.specification) && e.specificationLabels !== "无规格" && o.push(e.specification), A(e.color) && o.push(e.color), o.join(" * ");
}
function A7(e) {
  return e.specification;
}
function N7(e) {
  const o = [], n = [];
  return A(e.plateId) && n.push(e.plateId), A(e.thickness) && n.push(e.thickness), A(e.color) && n.push(e.color), A(n) && o.push(n.join("*")), o.join(" * ");
}
function L7(e) {
  return e.specification;
}
function I7(e, o) {
  const n = [], c = [];
  return A(e.thickness) && !isNaN(e.thickness) && c.push("厚(mm)"), A(e.width) && !isNaN(e.width) && c.push("宽(mm)"), A(e.length) && !isNaN(e.length) && c.push("长(mm)"), A(c) && n.push(c.join("*")), o === mo.LEFT_SPEC.V ? A(e.specificationLabels) && e.specificationLabels !== "无规格" && n.unshift(e.specificationLabels) : A(e.specificationLabels) && e.specificationLabels !== "无规格" && n.push(e.specificationLabels), n.join(" * ");
}
function C7(e, o) {
  const n = [];
  return A(e.length) && !isNaN(e.length) && n.push("长(mm)"), o === mo.LEFT_SPEC.V ? A(e.specificationLabels) && e.specificationLabels !== "无规格" && n.unshift(e.specificationLabels) : A(e.specificationLabels) && e.specificationLabels !== "无规格" && n.push(e.specificationLabels), n.join(" * ");
}
function P7(e, o) {
  const n = vi[Ge.STEEL_COIL.V], c = [], u = [];
  return A(e.thickness) && !isNaN(e.thickness) && u.push("厚(mm)"), A(e.width) && !isNaN(e.width) && u.push("宽(mm)"), A(e.length) && !isNaN(e.length) && u.push(`长(${n.length.unit})`), A(u) && c.push(u.join("*")), o === mo.LEFT_SPEC.V ? A(e.specificationLabels) && e.specificationLabels !== "无规格" && c.unshift(e.specificationLabels) : A(e.specificationLabels) && e.specificationLabels !== "无规格" && c.push(e.specificationLabels), A(e.color) && c.push("颜色"), c.join(" * ");
}
function O7(e) {
  const o = [];
  return A(e.specificationLabels) && e.specificationLabels !== "无规格" && o.push(e.specificationLabels), A(e.color) && o.push("颜色"), o.join(" * ");
}
function k7(e) {
  const o = [];
  return A(e.specificationLabels) && e.specificationLabels !== "无规格" && o.push(e.specificationLabels), A(e.color) && o.push("颜色"), o.join(" * ");
}
function D7(e) {
  const o = [];
  return A(e.specificationLabels) && e.specificationLabels !== "无规格" && o.push(e.specificationLabels), A(e.color) && o.push("颜色"), o.join(" * ");
}
function x7(e) {
  const o = [];
  return o.push("规格"), o.join(" * ");
}
function U7(e) {
  const o = [], n = [];
  return A(e.plateId) && n.push("板型"), A(e.thickness) && n.push("厚(mm)"), A(e.color) && n.push("颜色"), A(n) && o.push(n.join("*")), o.join(" * ");
}
function jrt(e) {
  const o = e.specNameKV, n = Object.keys(o), c = [];
  return n && n.forEach((u) => {
    (e.basicClass !== Ge.SECTION_STEEL.V || u !== e.nationalStandard) && c.push(`${u}: ${o[u]}`);
  }), c.join("　");
}
function Frt(e) {
  if (!e) return "";
  switch (e.basicClass) {
    case Ge.STEEL_PLATE.V:
      return `${Number(e.thickness)} * ${e.width} * ${e.length}`;
    case Ge.SECTION_STEEL.V:
      return `${e.specNameKV[e.nationalStandard] || ""}`;
    case Ge.STEEL_COIL.V:
      return `${Number(e.thickness)} * ${e.width}`;
    default:
      return "";
  }
}
async function Qt(e, { multipleSpec: o = false, prefix: n } = {}) {
  if (Ae(e)) return e;
  let c = e;
  n && (c = c.map((u) => u[n]));
  try {
    const u = c.filter((r) => r.basicClass & ho);
    if (A(u)) u.forEach((r) => {
      W7(r);
    });
    else {
      const r = [];
      let E;
      c = c.filter((b) => b && b.classifyId);
      const y = Tn(c.map((b) => b.classifyId));
      await E_(y), c.forEach((b) => {
        if (A(b.classifyId)) {
          let V;
          o ? V = Array.isArray(b.specifications) && b.specifications.length > 0 ? b.specifications[0] : "" : V = b.specification, V = A(V) ? V : "";
          const M = b.nationalStandard ? `${b.classifyId}_${b.nationalStandard}` : b.classifyId;
          E = Y7(M, V).then((g) => {
            K7(b, g, o);
          }), r.push(E);
        }
      }), await Promise.all(r);
    }
  } catch (u) {
    console.log("加载科目报错", u);
  }
  return e;
}
async function Y7(e, o) {
  var r, E;
  const n = _e.state.config.classifySpec[e];
  let c = [];
  n.basicClass === Ge.SECTION_STEEL.V && (c = ((E = (r = n.specList) == null ? void 0 : r.find((y) => y.spec === o)) == null ? void 0 : E.nationalStandardOptions) || []);
  const u = n.fullSpecMap.get(o);
  return A(u) ? { ...u, nationalStandardOptions: c } : { classify: n, index: [0], specificationLabels: "无规格", arr: [], spec: "", specKV: {}, specNameKV: {}, specArrKV: [], serialNumber: n.serialNumber, sn: n.serialNumber, nationalStandardOptions: c };
}
async function E_(e) {
  const o = Array.isArray(e) ? e : [e], n = _e.state.config.classifySpec, c = o.filter((u) => Ae(n[u]));
  c.length > 0 && (c.forEach((u) => {
    _e.state.config.classifySpec[u] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", c));
}
function K7(e, o, n = false) {
  var c, u, r, E, y, b, V, M, g;
  o && (n || (e.sn = o.sn, e.serialNumber = o.serialNumber), e.specMerge = Ki(e), e.specificationLabels = o.specificationLabels, e.classifySerialNumber = (c = o.classify) == null ? void 0 : c.serialNumber, e.basicClass = (u = o.classify) == null ? void 0 : u.basicClass, e.classifyId = (r = o.classify) == null ? void 0 : r.id, e.classifyFullPathId = (E = o.classify) == null ? void 0 : E.fullPathId, e.classifyFullName = (y = o.classify) == null ? void 0 : y.fullName, e.classification = e.basicClass < ua ? "钢材" : (b = o.classify) == null ? void 0 : b.fullPathName[0], e.classifyName = (V = o.classify) == null ? void 0 : V.name, e.classifyParentFullName = (M = o.classify) == null ? void 0 : M.parentFullName, e.measureUnit = o.classify.measureUnit, e.measurePrecision = o.classify.measurePrecision, e.accountingUnit = o.classify.accountingUnit, e.accountingPrecision = o.classify.accountingPrecision, e.outboundUnitType = (g = o.classify) == null ? void 0 : g.outboundUnitType, e.outboundUnit = e.outboundUnitType === hi.MEASURE.V ? e.measureUnit : e.accountingUnit, e.outboundUnitPrecision = e.outboundUnitType === hi.MEASURE.V ? e.measurePrecision : e.accountingPrecision, e.rejectUnitType = e.basicClass === Ge.STEEL_COIL.V ? hi.ACCOUNTING.V : e.outboundUnitType, e.rejectUnit = e.rejectUnitType === hi.MEASURE.V ? e.measureUnit : e.accountingUnit, e.rejectUnitPrecision = e.rejectUnitType === hi.MEASURE.V ? e.measurePrecision : e.accountingPrecision, e.basicClass === Ge.SECTION_STEEL.V && (e.nationalStandardOptions = o.nationalStandardOptions), e.specKV = o.specKV, e.specNameKV = o.specNameKV, e.basicClass === Ge.SECTION_STEEL.V && (e.unitWeight = o.unitWeight));
}
function W7(e) {
  const o = vi[e.basicClass];
  e.specMerge = Ki(e), e.measureUnit = o.measure.unit, e.measurePrecision = o.measure.precision;
  const n = e.basicClass === Ge.STRUC_MANUFACTURED.V ? e.wageQuotaType === Gi.WEIGHT.V ? o == null ? void 0 : o.weight : e.wageQuotaType === Gi.QUANTITY.V ? o == null ? void 0 : o.quantity : o == null ? void 0 : o.length : e.wageQuotaType === Gi.LENGTH.V ? o == null ? void 0 : o.length : e.wageQuotaType === Gi.QUANTITY.V ? o == null ? void 0 : o.quantity : o == null ? void 0 : o.area;
  e.accountingUnit = n.unit, e.accountingPrecision = n.precision;
}
const j7 = { __name: "table", props: { modelValue: { type: Boolean, require: true } }, emits: ["update:modelValue"], setup(e, { emit: o }) {
  const n = o, c = e, u = { batchAdd: false, add: false, edit: false, del: false, download: false }, r = Z(), { CRUD: E, crud: y, columns: b } = cu({ title: "库存预警", sort: ["id.desc"], optShow: { ...u }, crudApi: { get: nS } }, r), { visible: V, handleClose: M } = Ta({ emit: n, props: c }), { maxHeight: g } = Kt({ mainBox: ".inventory-notify-list", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, paginate: true, navbar: false }, V);
  return E.HOOK.handleRefresh = async (S, { data: h }) => {
    await Qt(h.content), h.content = await Ut(h.content, { toSmallest: false, toNum: false }), h.content.forEach((T) => {
      T.unit = T.unitType === hi.MEASURE.V ? T.measureUnit : T.accountingUnit;
    });
  }, (S, h) => {
    const T = vt, _ = Ve("common-table"), f = Ve("common-dialog"), m = oi;
    return w(), U(f, { title: "库存预警", modelValue: l(V), "onUpdate:modelValue": h[0] || (h[0] = (R) => Gt(V) ? V.value = R : null), width: "800px", "before-close": l(M), "show-close": true, "custom-class": "inventory-notify-list", top: "10vh" }, { default: p(() => [qe((w(), U(_, { ref_key: "tableRef", ref: r, data: l(y).data, "max-height": l(g), style: { width: "100%" } }, { default: p(() => [s(T, { label: "序号", type: "index", align: "center", width: "60" }), l(b).visible("serialNumber") ? (w(), U(T, { key: "serialNumber", "show-overflow-tooltip": true, prop: "serialNumber", label: "编码", align: "left", width: "150" }, { default: p(({ row: R }) => [s(Os, { id: R.workshopId }, null, 8, ["id"]), C("span", null, K(R.serialNumber), 1)]), _: 1 })) : H("", true), l(b).visible("classifyFullName") ? (w(), U(T, { key: "classifyFullName", "show-overflow-tooltip": true, prop: "classifyFullName", label: "科目", align: "left", "min-width": "180" })) : H("", true), l(b).visible("specification") ? (w(), U(T, { key: "specification", "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "left", "min-width": "150" })) : H("", true), l(b).visible("minimumInventory") ? (w(), U(T, { key: "minimumInventory", "show-overflow-tooltip": true, prop: "minimumInventory", label: "预警数量", align: "center", "min-width": "150" }, { default: p(({ row: R }) => [C("span", { style: ri([{ color: R.inventory > 0 ? "#f18121" : "red" }, { "margin-right": "5px" }]) }, K(l(ji)(R.inventory, R.unitType === l(hi).MEASURE.V ? R.measurePrecision : R.accountingPrecision)), 5), C("span", null, K(R.unitType === l(hi).MEASURE.V ? R.measureUnit : R.accountingUnit), 1)]), _: 1 })) : H("", true)]), _: 1 }, 8, ["data", "max-height"])), [[m, l(y).loading]]), s(l(td))]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, F7 = ut(j7, [["__scopeId", "data-v-2ab20eda"]]);
const z7 = { class: "notify-component" }, B7 = { __name: "index", setup(e) {
  const o = Z(false), n = Z(0);
  bl(() => {
    clearInterval(c);
  }), u();
  const c = setInterval(() => {
    u();
  }, 6e4);
  async function u() {
    try {
      const { totalElements: r = 0 } = await nS();
      n.value = r;
    } catch (r) {
      console.log("获取库存预警列表失败", r);
    }
  }
  return (r, E) => {
    const y = _o, b = zn;
    return w(), Q("div", z7, [s(b, { value: n.value, max: 99, hidden: n.value < 1 }, { default: p(() => [s(y, { "icon-class": "notify", onClick: E[0] || (E[0] = (V) => o.value = true) })]), _: 1 }, 8, ["value", "hidden"]), s(F7, { modelValue: o.value, "onUpdate:modelValue": E[1] || (E[1] = (V) => o.value = V) }, null, 8, ["modelValue"])]);
  };
} };
function H7(e) {
  return W({ module: "wms", url: "inbound/application/record/raw-materials", method: "get", params: e });
}
function mu(e) {
  return W({ url: "/api/v2/wms/inbound/application/record/raw-materials", method: "put", data: e });
}
function q7(e) {
  return W({ module: "wms", url: "inbound/application/record/raw-materials", method: "delete", data: e });
}
function TS(e) {
  return W({ url: `/api/v2/wms/inbound/application/record/raw-materials/${e}`, method: "get" });
}
const zrt = { get: H7, edit: mu, del: q7, detail: TS };
function G7(e) {
  return W({ module: "wms", url: "inbound/application/review/raw-materials", method: "get", params: e });
}
function Q7(e) {
  return W({ url: `/api/v2/wms/inbound/application/record/raw-materials/${e}`, method: "get" });
}
function z2(e) {
  return W({ url: "/api/v2/wms/inbound/application/review/revocation", method: "post", data: e });
}
function _S(e, o) {
  return W({ url: "/api/v2/wms/inbound/application/review/partyA/approval", method: "post", params: e, data: o });
}
