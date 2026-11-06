import { ref as n } from "vue";
import { watch as H } from "vue";
import { computed as O } from "vue";
import { resolveComponent as f } from "vue";
import { unref as o } from "vue";
import { openBlock as c } from "vue";
import { createBlock as v } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as q } from "vue";
import { createElementBlock as x } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as I } from "vue";
import { createCommentVNode as N } from "vue";
import { withDirectives as C } from "vue";
import { ElMessage as A } from "element-plus";
import { ElTableColumn as T } from "element-plus";
import { ElCard as z } from "element-plus";
import { vLoading as G } from "element-plus";
import { c as J, e as L } from "../../../../modules/install-config-0f2e817e.js";
import { _ as Q, m as F, x as K, o as $, G as p, au as W } from "../../../../shared/runtime.js";
import { j as X } from "../../../../modules/project-19a12d6b.js";
const Y = { key: 0, style: { float: "right" } }, Z = { __name: "auxiliary-config", setup(ee) {
  const r = X.auxiliaryMaterial, { globalProjectId: m } = F(["globalProjectId"]), R = { add: false, edit: false, del: false, download: false }, k = n(false), d = n(false), w = n([]), t = n([]), _ = n(), { crud: s, CRUD: j } = K({ title: "配套件安装设置", sort: [], permission: { ...r }, optShow: { ...R }, crudApi: { ...J }, requiredQuery: ["projectId"], hasPagination: false }, _), { maxHeight: V } = $({ paginate: true, extraHeight: 130 });
  H(() => m.value, (e) => {
    e && (s.query.projectId = m.value, s.toQuery());
  }, { immediate: true, deep: true });
  function E(e) {
    e.boolNoReport !== e.sourceRow.boolNoReport ? t.value.findIndex((a) => a.classifyId === e.classifyId) < 0 && t.value.push({ projectId: e.projectId, classifyId: e.classifyId, boolNoReport: e.boolNoReport }) : t.value.findIndex((a) => a.classifyId === e.classifyId) > -1 && t.value.splice(t.value.findIndex((a) => a.classifyId === e.classifyId), 1);
  }
  const M = O(() => !!t.value.length);
  j.HOOK.handleRefresh = (e, a) => {
    w.value = JSON.parse(JSON.stringify(a.data.content));
  };
  async function S() {
    d.value = true;
    try {
      await L(t.value), A.success("修改成功"), t.value = [], s.refresh();
    } catch (e) {
      console.log("安装设置", e);
    } finally {
      d.value = false;
    }
  }
  function D() {
    t.value = [], s.refresh();
  }
  return (e, a) => {
    const y = f("common-button"), g = T, P = f("common-radio"), U = f("common-table"), B = z, h = G;
    return o(p)(o(r).get) ? (c(), v(B, { key: 0, class: "box-card", shadow: "" }, { header: l(() => [a[2] || (a[2] = q("span", { class: "title" }, "配套件安装设置", -1)), o(p)(o(r).edit) && M.value ? (c(), x("div", Y, [i(y, { size: "default", type: "warning", onClick: D }, { default: l(() => a[0] || (a[0] = [I("取消修改")])), _: 1, __: [0] }), i(y, { loading: d.value, size: "default", type: "success", onClick: S }, { default: l(() => a[1] || (a[1] = [I("保存")])), _: 1, __: [1] }, 8, ["loading"])])) : N("", true)]), default: l(() => [C((c(), x("div", null, [C((c(), v(U, { ref_key: "tableRef", ref: _, data: o(s).data, "empty-text": o(s).emptyText, "max-height": o(V), border: false, style: { width: "100%" }, stripe: false, showEmptySymbol: false }, { default: l(() => [i(g, { key: "classifyName", prop: "classifyName", label: "配套件产品分类", align: "center" }), i(g, { key: "boolNoReport", prop: "boolNoReport", label: "即入即安", align: "center", width: "180" }, { default: l((u) => [i(P, { modelValue: u.row.boolNoReport, "onUpdate:modelValue": (b) => u.row.boolNoReport = b, options: o(W).ENUM, type: "enum", onChange: (b) => E(u.row), disabled: !o(p)(o(r).edit) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange", "disabled"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[h, o(s).loading]])])), [[h, k.value || d.value]])]), _: 1 })) : N("", true);
  };
} }, le = Q(Z, [["__scopeId", "data-v-1b78309d"]]);
export {
  le as default
};
