import { inject as m } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as V } from "vue";
import { createBlock as M } from "vue";
import { withCtx as n } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as g } from "vue";
import { toDisplayString as p } from "vue";
import { unref as s } from "vue";
import { mergeProps as U } from "vue";
import { watch as u } from "vue";
import { ElTableColumn as z } from "element-plus";
import { am as F, sQ as O, i as h, p as R, z as $, aw as A, sT as D, iX as b, uZ as Q, c9 as o } from "../../../../../../../../../shared/runtime.js";
const J = { __name: "steel-plate-table", emits: ["add-purchase"], setup(X, { expose: y, emit: _ }) {
  var d;
  const w = _, v = F.STEEL_PLATE.V, T = m("bcListObj"), r = (d = m("cu")) == null ? void 0 : d.form, { baseUnit: c } = O(v), { handleMeteChangeCalcPrice: W } = Q("weighingTotalWeight"), C = { width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: o, message: "宽度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: o, message: "重量必须大于0", trigger: "blur" }], length: [{ required: false, message: "请填写长度", trigger: "blur" }, { pattern: o, message: "长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: o, message: "数量必须大于0", trigger: "blur" }] }, { tableValidate: j, wrongCellMask: k } = A({ rules: C, errorMsg: "请修正【钢板清单】中标红的信息" });
  function q(e) {
    var i;
    return !!(((i = r.steelPlateList) == null ? void 0 : i.findIndex((t) => t.id === e.id)) !== -1 || r.projectId && e.projectId !== r.projectId);
  }
  function x(e) {
    u([() => e.length, () => e.width, () => e.thickness, c], () => N(e)), u([() => e.theoryWeight, () => e.quantity], () => P(e)), u([() => e.weighingTotalWeight], () => W(e));
  }
  async function N(e) {
    e.theoryWeight = await D({ classifyId: e.classifyId, name: e.classifyFullName, length: e.length, width: e.width, thickness: e.thickness });
  }
  function P(e) {
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
    const t = z, L = f("common-button"), S = f("common-table");
    return V(), M(S, U(e.$attrs, { data: s(T).steelPlateList, "cell-class-name": s(k), "show-empty-symbol": false, "return-source-data": "" }), { default: n(() => [a(t, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), a(t, { label: "申购单号", prop: "purchaseSN", fixed: "left", width: "140", align: "center" }, { default: n(({ row: l }) => [g("span", null, p(l.purchaseSN), 1)]), _: 1 }), a(t, { align: "center", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }), a(t, { align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" }), a(t, { align: "center", label: "型号", prop: "model", "show-overflow-tooltip": "" }), a(t, { align: "center", label: "计量单位", prop: "measureUnit", width: "80", "show-overflow-tooltip": "" }), a(t, { align: "center", label: "数量", prop: "quantity", width: "75", "show-overflow-tooltip": "" }), a(t, { align: "center", label: "申购量", prop: "mete", width: "90", "show-overflow-tooltip": "" }), a(t, { align: "center", label: "品牌", prop: "brand", width: "90", "show-overflow-tooltip": "" }), a(t, { align: "center", label: "需求时间", prop: "arrivalTime", "show-overflow-tooltip": "" }, { default: n(({ row: l }) => [g("span", null, p(s(h)(l.arrivalTime) ? s(R)(l.arrivalTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), a(t, { align: "center", label: "项目", prop: "project", "show-overflow-tooltip": "" }, { default: n(({ row: l }) => [g("span", null, p(s(h)(l.project) ? s($)(l.project) : "-"), 1)]), _: 1 }), a(t, { align: "center", label: "备注", prop: "remark", "show-overflow-tooltip": "" }), a(t, { label: "操作", width: "90", align: "center", fixed: "right" }, { default: n(({ row: l, $index: B }) => [a(L, { icon: "el-icon-plus", disabled: q(l), type: "warning", size: "default", onClick: (Z) => E(l, B) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["data", "cell-class-name"]);
  };
} };
export {
  J as default
};
