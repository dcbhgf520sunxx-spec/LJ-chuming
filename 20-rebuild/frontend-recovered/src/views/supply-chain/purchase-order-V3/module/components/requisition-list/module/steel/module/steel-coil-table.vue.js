import { inject as h } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as V } from "vue";
import { createBlock as $ } from "vue";
import { withCtx as s } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as g } from "vue";
import { toDisplayString as u } from "vue";
import { unref as n } from "vue";
import { mergeProps as q } from "vue";
import { watch as b } from "vue";
import { ElTableColumn as M } from "element-plus";
import { am as O, sQ as z, i as p, p as F, z as P, aw as R, va as U, c9 as o } from "../../../../../../../../../shared/runtime.js";
const H = { __name: "steel-coil-table", emits: ["add-purchase"], setup(D, { expose: f, emit: _ }) {
  var d;
  const w = _, y = O.STEEL_COIL.V, k = h("bcListObj"), c = (d = h("cu")) == null ? void 0 : d.form, { baseUnit: r } = z(y), C = { width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: o, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { pattern: o, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: o, message: "重量必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { pattern: o, message: "长度必须大于0", trigger: "blur" }] }, { tableValidate: T, wrongCellMask: v } = R({ rules: C, errorMsg: "请修正【钢卷清单】中标红的信息" });
  function L(e) {
    var i;
    return !!(((i = c.steelCoilList) == null ? void 0 : i.findIndex((t) => t.id === e.id)) !== -1 || c.projectId && e.projectId !== c.projectId);
  }
  function x(e) {
    b([() => e.weighingTotalWeight, () => e.width, () => e.thickness, r], () => j(e)), b([() => e.theoryLength], () => N(e));
  }
  async function j(e) {
    e.theoryLength = await U({ classifyId: e.classifyId, name: e.classifyFullName, weight: e.weighingTotalWeight, width: e.width, thickness: e.thickness });
  }
  function N(e) {
    p(e.theoryLength) ? e.length = e.theoryLength * 1 : e.length = void 0;
  }
  function I(e, i) {
    w("add-purchase", e, i);
  }
  function W(e) {
    const { validResult: i } = T(e);
    return i;
  }
  return f({ rowWatch: x, validate: W }), (e, i) => {
    const t = M, B = m("common-button"), E = m("common-table");
    return V(), $(E, q(e.$attrs, { data: n(k).steelCoilList, "cell-class-name": n(v), "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }), { default: s(() => [a(t, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), a(t, { label: "申购单号", prop: "purchaseSN", fixed: "left", width: "140", align: "center" }, { default: s(({ row: l }) => [g("span", null, u(l.purchaseSN), 1)]), _: 1 }), a(t, { prop: "serialNumber", label: "编号", align: "center", fixed: "left" }), a(t, { prop: "classifyName", label: "物料种类", align: "center", fixed: "left", "show-overflow-tooltip": "" }), a(t, { prop: "specification", label: "规格", align: "center", fixed: "left", "show-overflow-tooltip": "" }), a(t, { key: "weighingTotalWeight", prop: "weighingTotalWeight", align: "center", label: `总重 (${n(r).weight.unit})` }, null, 8, ["label"]), a(t, { prop: "thickness", align: "center", label: `厚 (${n(r).thickness.unit})` }, null, 8, ["label"]), a(t, { prop: "width", align: "center", label: `宽 (${n(r).width.unit})` }, null, 8, ["label"]), a(t, { prop: "length", align: "center", label: "长 (m)" }), a(t, { prop: "color", label: "颜色", align: "center" }), a(t, { prop: "brand", label: "品牌", align: "center" }), a(t, { align: "center", label: "需求时间", prop: "arrivalTime", "show-overflow-tooltip": "" }, { default: s(({ row: l }) => [g("span", null, u(n(p)(l.arrivalTime) ? n(F)(l.arrivalTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), a(t, { align: "center", label: "项目", prop: "project", "show-overflow-tooltip": "" }, { default: s(({ row: l }) => [g("span", null, u(n(p)(l.project) ? n(P)(l.project) : "-"), 1)]), _: 1 }), a(t, { label: "操作", width: "90", align: "center", fixed: "right" }, { default: s(({ row: l, $index: S }) => [a(B, { icon: "el-icon-plus", disabled: L(l), type: "warning", size: "default", onClick: (Q) => I(l, S) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["data", "cell-class-name"]);
  };
} };
export {
  H as default
};
