import { ref as l } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as I } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as t } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as v } from "vue";
import { withModifiers as C } from "vue";
import { createTextVNode as g } from "vue";
import { unref as r } from "vue";
import { Fragment as z } from "vue";
import { renderList as B } from "vue";
import { normalizeClass as L } from "vue";
import { toDisplayString as O } from "vue";
import { createCommentVNode as W } from "vue";
import { withDirectives as A } from "vue";
import { createBlock as F } from "vue";
import { ElInput as U } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { ElCard as M } from "element-plus";
import { _ as $, i as j, fd as P, fb as G } from "../../../../../../../../shared/runtime.js";
import H from "../../../component/form.vue.js";
const J = { class: "clearfix" }, K = { __name: "index", props: { data: { type: Array, default: () => [] } }, emits: ["success"], setup(w, { emit: b }) {
  const k = w, x = b, h = l(), V = [], c = l(false), p = l({}), s = l();
  function D(d) {
    p.value = d, c.value = true;
  }
  function _() {
    document.querySelectorAll(".name-color").forEach((e) => {
      s.value && e.innerText.includes(s.value) ? e.style.color = "red" : e.style.color = "";
    });
  }
  function N() {
    s.value = void 0, _();
  }
  return (d, e) => {
    const S = U, u = y("common-button"), m = q, R = y("common-table"), T = M, E = I("permission");
    return i(), f("div", null, [t(T, { shadow: "always", class: "section-config" }, { header: a(() => [v("div", J, [e[5] || (e[5] = v("span", { class: "card-title" }, "主构件/次构件名称库", -1)), t(S, { modelValue: s.value, "onUpdate:modelValue": e[0] || (e[0] = (o) => s.value = o), size: "default", placeholder: "输入名称搜索", style: { width: "240px", margin: "0 20px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), t(u, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: C(_, ["stop"]) }, { default: a(() => e[3] || (e[3] = [g(" 搜索 ")])), _: 1, __: [3] }), t(u, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: C(N, ["stop"]) }, { default: a(() => e[4] || (e[4] = [g(" 重置 ")])), _: 1, __: [4] })])]), default: a(() => [t(R, { ref_key: "tableRef", ref: h, "data-format": V, data: k.data }, { default: a(() => [t(m, { key: "typeName", "show-overflow-tooltip": true, prop: "typeName", label: "类型", align: "center", width: "120" }), t(m, { key: "sectionWarehouseConfigDTOList", prop: "sectionWarehouseConfigDTOList", label: "名称分类", align: "left" }, { default: a(({ row: { sourceRow: o } }) => [r(j)(o.sectionWarehouseConfigDTOList) ? (i(true), f(z, { key: 0 }, B(o.sectionWarehouseConfigDTOList, (n) => (i(), f("span", { class: L([n.source === r(P).USER_ADDITION.V ? "user_addition" : "", "name-color"]), key: n.name }, " 【" + O(n.name) + "】 ", 3))), 128)) : W("", true)]), _: 1 }), A((i(), F(m, { label: "操作", width: "100px", align: "center", fixed: "right" }, { default: a(({ row: { sourceRow: o } }) => [t(u, { icon: "el-icon-edit", type: "primary", size: "default", onClick: (n) => D(o) }, null, 8, ["onClick"])]), _: 1 })), [[E, r(G).edit]])]), _: 1 }, 8, ["data"])]), _: 1 }), t(r(H), { modelValue: c.value, "onUpdate:modelValue": e[1] || (e[1] = (o) => c.value = o), onSuccess: e[2] || (e[2] = (o) => x("success")), detailInfo: p.value }, null, 8, ["modelValue", "detailInfo"])]);
  };
} }, Z = $(K, [["__scopeId", "data-v-0405c770"]]);
export {
  Z as default
};
