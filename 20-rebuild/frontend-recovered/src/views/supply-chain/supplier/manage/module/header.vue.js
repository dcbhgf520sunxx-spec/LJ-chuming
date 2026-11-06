import { inject as S } from "vue";
import { useRouter as B } from "vue-router";
import { computed as D } from "vue";
import { resolveComponent as f } from "vue";
import { resolveDirective as H } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as I } from "vue";
import { withDirectives as _ } from "vue";
import { vShow as T } from "vue";
import { unref as e } from "vue";
import { createElementVNode as z } from "vue";
import { createVNode as a } from "vue";
import { withKeys as K } from "vue";
import { withCtx as l } from "vue";
import { createBlock as d } from "vue";
import { createTextVNode as p } from "vue";
import { createCommentVNode as y } from "vue";
import { ElMessage as O } from "element-plus";
import { ElInput as Q } from "element-plus";
import { ln as g, B as q, C as L, L as v, x1 as R, G as b, x2 as U, x3 as $, E as j } from "../../../../../shared/runtime.js";
import A from "../../../../plan/technical-manage/artifact-tree/module/ExcelUploadBtnV2.vue.js";
const F = { class: "head-container" }, W = { __name: "header", setup(M) {
  const h = { name: void 0, boolHide: g.FALSE.V }, u = S("permission"), { crud: o, query: s } = q(h), x = B(), E = D(() => {
    if ((o.selections || []).length !== 1) return false;
    const [n] = o.selections || [];
    return c(n);
  });
  function V() {
    o.toQuery();
  }
  function w() {
    var t;
    const [n] = o.selections || [];
    if (n) {
      if (!c(n)) {
        O.warning("所选供应商未配置评价分类，无法评价");
        return;
      }
      x.push({ path: "/supply-chain/supplier/evaluation-manage/evaluation-operate", query: { supplierId: n.id, supplierName: n.name, classifyId: (t = n == null ? void 0 : n.scmSupplierConfigDTO) == null ? void 0 : t.id } });
    }
  }
  function c(n = {}) {
    var i;
    const t = (i = n == null ? void 0 : n.scmSupplierConfigDTO) == null ? void 0 : i.id;
    return t != null && t !== "";
  }
  return (n, t) => {
    const i = f("common-radio-button"), C = Q, k = f("common-button"), N = H("permission");
    return r(), I("div", F, [_(z("div", null, [a(i, { modelValue: e(s).boolHide, "onUpdate:modelValue": t[0] || (t[0] = (m) => e(s).boolHide = m), options: e(g).ENUM, class: "filter-item", showOptionAll: "", type: "enum", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(C, { modelValue: e(s).name, "onUpdate:modelValue": t[1] || (t[1] = (m) => e(s).name = m), class: "filter-item", clearable: "", placeholder: "请输入供应商名称", size: "default", style: { width: "200px" }, onKeyup: K(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(e(L))], 512), [[T, e(o).searchToggle]]), a(e(j), null, { viewLeft: l(() => [_((r(), d(v, { fn: e(R), params: e(s), "response-header-result": "", style: { "margin-right": "5px" } }, { default: l(() => t[2] || (t[2] = [p(" 供应商清单下载（根据查询条件） ")])), _: 1, __: [2] }, 8, ["fn", "params"])), [[N, e(u).get]]), e(b)(e(u).import) ? (r(), d(A, { key: 0, "upload-fun": e(U), "btn-name": "清单导入", "btn-size": "default", "btn-type": "warning", class: "filter-item", style: { flex: "1" }, onSuccess: V }, null, 8, ["upload-fun"])) : y("", true), e(b)(e(u).import) ? (r(), d(v, { key: 1, fn: e($), class: "filter-item", size: "default", type: "info" }, { default: l(() => t[3] || (t[3] = [p(" 导入模板下载 ")])), _: 1, __: [3] }, 8, ["fn"])) : y("", true)]), optRight: l(() => [a(k, { class: "filter-item", size: "default", type: "primary", disabled: !E.value, onClick: w }, { default: l(() => t[4] || (t[4] = [p(" 评价 ")])), _: 1, __: [4] }, 8, ["disabled"])]), _: 1 })]);
  };
} };
export {
  W as default
};
