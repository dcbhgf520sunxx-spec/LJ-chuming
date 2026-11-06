import { inject as m } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as V } from "vue";
import { createBlock as B } from "vue";
import { withCtx as n } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as g } from "vue";
import { unref as s } from "vue";
import { mergeProps as R } from "vue";
import { watch as u } from "vue";
import { ElTableColumn as O } from "element-plus";
import { cP as U, sQ as z, i as h, p as A, z as F, aw as $, sT as D, iX as b, uZ as H, c9 as o } from "../../../../../../../../../shared/runtime.js";
const J = { __name: "other-steel-material-table", emits: ["add-purchase"], setup(Q, { expose: y, emit: _ }) {
  var d;
  const w = _, v = U.OTHER_STEEL_MATERIALS.V, T = m("bcListObj"), r = (d = m("cu")) == null ? void 0 : d.form, { baseUnit: c } = z(v), { handleMeteChangeCalcPrice: W } = H("mete"), C = { width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: o, message: "宽度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: o, message: "重量必须大于0", trigger: "blur" }], length: [{ required: false, message: "请填写长度", trigger: "blur" }, { pattern: o, message: "长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: o, message: "数量必须大于0", trigger: "blur" }] }, { tableValidate: j, wrongCellMask: k } = $({ rules: C, errorMsg: "请修正【其它钢材清单】中标红的信息" });
  function q(e) {
    var i;
    return !!(((i = r.otherSteelMaterialList) == null ? void 0 : i.findIndex((t) => t.id === e.id)) !== -1 || r.projectId && e.projectId !== r.projectId);
  }
  function x(e) {
    u([() => e.length, () => e.width, () => e.thickness, c], () => N(e)), u([() => e.theoryWeight, () => e.quantity], () => S(e)), u([() => e.weighingTotalWeight], () => W(e));
  }
  async function N(e) {
    e.theoryWeight = await D({ classifyId: e.classifyId, name: e.classifyFullName, length: e.length, width: e.width, thickness: e.thickness });
  }
  function S(e) {
    h(e.theoryWeight) && e.quantity ? (e.theoryTotalWeight = b(e.theoryWeight * e.quantity, c.value.weight.precision), e.weighingTotalWeight = b(e.theoryWeight * e.quantity, c.value.weight.precision)) : (e.theoryTotalWeight = void 0, e.weighingTotalWeight = void 0);
  }
  function E(e, i) {
    w("add-purchase", e, i);
  }
  function I(e) {
    const { validResult: i } = j(e);
    return i;
  }
  return y({ rowWatch: x, validate: I }), (e, i) => {
    const t = O, M = f("common-button"), P = f("common-table");
    return V(), B(P, R(e.$attrs, { data: s(T).otherSteelMaterialList, "cell-class-name": s(k), "show-empty-symbol": false, "return-source-data": "" }), { default: n(() => [a(t, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), a(t, { label: "申购单号", prop: "purchaseSN", fixed: "left", width: "140", align: "center" }, { default: n(({ row: l }) => [p("span", null, g(l.purchaseSN), 1)]), _: 1 }), a(t, { align: "center", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }), a(t, { align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" }), a(t, { align: "center", label: "型号", prop: "model", "show-overflow-tooltip": "" }), a(t, { align: "center", label: "计量单位", prop: "measureUnit", width: "80", "show-overflow-tooltip": "" }), a(t, { align: "center", label: "数量", prop: "quantity", width: "75", "show-overflow-tooltip": "" }), a(t, { align: "center", label: "申购量", prop: "mete", width: "90", "show-overflow-tooltip": "" }), a(t, { align: "center", label: "品牌", prop: "brand", width: "90", "show-overflow-tooltip": "" }), a(t, { align: "center", label: "需求时间", prop: "arrivalTime", "show-overflow-tooltip": "" }, { default: n(({ row: l }) => [p("span", null, g(s(h)(l.arrivalTime) ? s(A)(l.arrivalTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), a(t, { align: "center", label: "项目", prop: "project", "show-overflow-tooltip": "" }, { default: n(({ row: l }) => [p("span", null, g(s(h)(l.project) ? s(F)(l.project) : "-"), 1)]), _: 1 }), a(t, { align: "center", label: "备注", prop: "remark", "show-overflow-tooltip": "" }), a(t, { label: "操作", width: "90", align: "center", fixed: "right" }, { default: n(({ row: l, $index: L }) => [a(M, { icon: "el-icon-plus", disabled: q(l), type: "warning", size: "default", onClick: (X) => E(l, L) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["data", "cell-class-name"]);
  };
} };
export {
  J as default
};
