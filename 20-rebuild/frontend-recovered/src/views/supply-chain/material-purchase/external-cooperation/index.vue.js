import { ref as c } from "vue";
import { computed as d } from "vue";
import { provide as T } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as N } from "vue";
import { createVNode as e } from "vue";
import { withCtx as r } from "vue";
import { createElementVNode as S } from "vue";
import { toDisplayString as b } from "vue";
import { unref as o } from "vue";
import { createTextVNode as V } from "vue";
import { createBlock as D } from "vue";
import { resolveDynamicComponent as F } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElTag as L } from "element-plus";
import { ElButton as M } from "element-plus";
import R from "./module/header.vue.js";
import { l as $, x as z, uH as I, o as J, k_ as K, uI as g, uJ as O, uK as f } from "../../../../shared/runtime.js";
function P(s) {
  return $({ url: "/api/v2/supply-chain/order-payment/outsourcing/standingBook", method: "get", params: s });
}
const U = { get: P }, q = { class: "app-container" }, Y = { __name: "index", setup(s) {
  const h = { 1: O, 2: f, 3: f }, x = c(), { crud: p } = z({ title: "外协合同", crudApi: { ...U }, permission: I }, x), l = c(), m = c(), v = (n) => {
    m.value = n.projectAttributeEnum, l.value = n, p.toAdd();
  }, C = d(() => h[m.value]), y = c([["planCreateTime", ["parse-time", "{y}-{d}-{m}"]]]), { maxHeight: E } = J({ paginate: true });
  return T("common", { projectAttribute: d(() => {
    var n;
    return (n = l == null ? void 0 : l.value) == null ? void 0 : n.projectAttributeEnum;
  }) }), (n, G) => {
    const t = H, A = L, j = M, k = B("common-table");
    return _(), N("div", q, [e(R), e(k, { ref: "external-cooperation", data: o(p).data, "data-format": y.value, "empty-text": o(p).emptyText, "max-height": o(E) }, { default: r(() => [e(t, { align: "center", label: "序号", type: "index", width: "60" }), e(t, { align: "center", label: "项目类型", prop: "projectAttributeEnum" }, { default: r(({ row: a }) => [S("span", null, b(o(K).VL[a.projectAttributeEnum]), 1)]), _: 1 }), e(t, { align: "center", label: "编号", prop: "serialNumber" }), e(t, { align: "center", label: "项目", "min-width": "160", prop: "project.name" }), e(t, { align: "center", label: "单体", prop: "monomerName" }), e(t, { align: "center", label: "区域", "min-width": "160", prop: "monomerName" }), e(t, { align: "center", label: "单位", prop: "unit" }), e(t, { align: "center", label: "清单量", prop: "mete" }), e(t, { align: "center", label: "供应商", "min-width": "160", prop: "supplier" }), e(t, { align: "center", label: "计划创建人", prop: "planCreator" }), e(t, { align: "center", label: "创建日期", prop: "planCreateTime", width: "120" }), e(t, { align: "center", label: "合同状态", prop: "contractStatusEnum" }, { default: r(({ row: a }) => {
      var i, u;
      return [e(A, { type: (u = (i = o(g)) == null ? void 0 : i.VL[a == null ? void 0 : a.contractStatusEnum]) == null ? void 0 : u.T, size: "default" }, { default: r(() => [V(b(o(g).VL[a == null ? void 0 : a.contractStatusEnum]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 }), e(t, { align: "center", label: "操作", width: "80" }, { default: r(({ row: a }) => [e(j, { icon: "el-icon-view", type: "primary", onClick: (i) => v(a) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"]), (_(), D(F(C.value)))]);
  };
} };
export {
  Y as default
};
