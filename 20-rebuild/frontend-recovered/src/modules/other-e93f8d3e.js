import { vP as b, j as l, am as E, V as U, vR as _, f3 as N, vT as d, aI as w, iX as p } from "../shared/runtime.js";
const P = { title: "其它申购清单", dlgWidth: "1500px", startRow: 2, endIgnoreRow: 1, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (m) => {
  var y;
  if (!b(m, P.rules)) return;
  l.state.config.loaded.matClsTree || await l.dispatch("config/fetchMatClsTree");
  const g = l.state.config.rawMatClsList.filter((e) => e.basicClass === E.OTHER.V), c = l.state.config.rawMatClsKV, n = U(m), u = [];
  let t = [];
  if (n.forEach((e) => {
    let s = false;
    const i = _(e.classifyName.split("/"));
    for (const a of g) if (a.fullPathName.length >= i.length && N(a.fullPathName.slice(-i.length), i)) {
      s = true, e.classifyId = a.id, u.push(a.id);
      break;
    }
    s || t.push(e.classifyName);
  }), t = Array.from(new Set(t)), t.length > 0) throw new Error(`${t.map((e) => `“${e}”`).join("、")}${t.length > 1 ? "等" : ""}物料种类不存在`);
  const f = l.state.config.classifySpec, r = u.filter((e) => f[e] === void 0);
  r.length > 0 && (r.forEach((e) => {
    f[e] = {};
  }), await l.dispatch("config/fetchMarClsSpec", r));
  for (const e of n) {
    if (((y = c == null ? void 0 : c[e.classifyId]) == null ? void 0 : y.isLeaf) === false) throw new Error(`${e.classifyName}不是末级科目`);
    const s = f[e.classifyId];
    if (s.hasUnitConfig === false) throw new Error(`${e.classifyName}未配置核算单位`);
    let i;
    const a = e.specification ?? "";
    if (s && Array.isArray(s.specList)) {
      for (const o of s.specList) if (a === o.spec) {
        if (i = o, e.measureUnit) {
          if (!i.classify.measureUnit) throw new Error(`${e.classifyName}不存在计量单位`);
          if (!await d(i.classify.measureUnit, e.measureUnit)) throw new Error(`${e.classifyName}填写的计量单位错误，单位应为：“${i.classify.measureUnit}”`);
        }
        if (e.accountingUnit && !await d(i.classify.accountingUnit, e.accountingUnit)) throw new Error(`${e.classifyName}填写的核算单位错误，单位应为：“${i.classify.accountingUnit}”`);
        break;
      }
    }
    if (i) e.uid = w(), e.sn = i.sn, e.specificationLabels = i.specificationLabels, e.serialNumber = i.serialNumber, e.classifySerialNumber = i.classify.serialNumber, e.classifyId = i.classify.id, e.classifyFullPathId = i.classify.fullPathId, e.classifyFullName = i.classify.fullName, e.classifyName = i.classify.name, e.classifyParentFullName = i.classify.parentFullName, e.basicClass = i.classify.basicClass, e.specification = i.spec, e.specificationMap = i.specKV, e.measureUnit = i.classify.measureUnit, e.accountingUnit = i.classify.accountingUnit, e.accountingPrecision = i.classify.accountingPrecision, e.measurePrecision = i.classify.measurePrecision, e.quantity && (e.quantity = p(e.quantity, e.measurePrecision)), e.mete && (e.mete = p(e.mete, e.accountingPrecision)), e.measureUnit || (e.quantity = void 0);
    else throw new Error(`${e.classifyName}下不存在规格为“${a}”的材料，请联系管理员/仓库人员添加`);
  }
  return n;
} };
export {
  P as s
};
