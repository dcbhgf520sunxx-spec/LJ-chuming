import { ref as m } from "vue";
import { onMounted as G } from "vue";
import { computed as d } from "vue";
import { resolveComponent as H } from "vue";
import { unref as r } from "vue";
import { openBlock as t } from "vue";
import { createBlock as i } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as C } from "vue";
import { createTextVNode as I } from "vue";
import { createCommentVNode as p } from "vue";
import { withDirectives as L } from "vue";
import { createVNode as k } from "vue";
import { createElementBlock as U } from "vue";
import { toDisplayString as $ } from "vue";
import { ElMessage as E } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { ElInput as q } from "element-plus";
import { ElTable as F } from "element-plus";
import { ElCard as K } from "element-plus";
import { vLoading as Q } from "element-plus";
import { _ as R, G as v, fT as _ } from "../../../../../shared/runtime.js";
import { g as W, e as X } from "../../../../../modules/supplier-evaluation-config-2fb6916b.js";
const Y = { class: "card-header" }, Z = { key: 1 }, ee = { __name: "evaluation-category", props: { tableMaxHeight: { type: Number, default: void 0 } }, setup(A) {
  const c = m(false), u = m(false), o = m([]), g = m([]);
  G(() => {
    h();
  });
  const x = d(() => o.value.map((e) => ({ id: e.id ?? null, name: e.name || "" }))), N = d(() => g.value.map((e) => ({ id: e.id ?? null, name: e.name || "" }))), b = d(() => JSON.stringify(x.value) !== JSON.stringify(N.value)), V = d(() => c.value || u.value || !b.value);
  async function h() {
    c.value = true;
    try {
      const e = await W();
      o.value = w(e), g.value = z(o.value);
    } catch (e) {
      console.log("供应商评价配置-评价分类列表", e);
    } finally {
      c.value = false;
    }
  }
  async function D() {
    if (!b.value || !o.value.length) return;
    if (o.value.some((a) => !a.name)) {
      E.error("请填写完整的评价分类名称");
      return;
    }
    u.value = true;
    try {
      await X(o.value.map((a) => ({ id: a.id, name: a.name }))), E.success("评价分类保存成功"), await h();
    } catch (a) {
      console.log("供应商评价配置-评价分类保存", a);
    } finally {
      u.value = false;
    }
  }
  function w(e) {
    return B(e).map((l) => ({ id: l.id, name: l.name || "", editing: false, backupName: l.name || "" }));
  }
  function M(e) {
    e.backupName = e.name || "", e.editing = true;
  }
  function S(e) {
    e.name = e.backupName || "", e.editing = false;
  }
  function B(e) {
    var a;
    return Array.isArray(e) ? e : Array.isArray(e == null ? void 0 : e.content) ? e.content : Array.isArray((a = e == null ? void 0 : e.data) == null ? void 0 : a.content) ? e.data.content : Array.isArray(e == null ? void 0 : e.records) ? e.records : Array.isArray(e == null ? void 0 : e.list) ? e.list : Array.isArray(e == null ? void 0 : e.data) ? e.data : [];
  }
  function z(e) {
    return JSON.parse(JSON.stringify(e));
  }
  return (e, a) => {
    const l = H("common-button"), y = j, J = q, O = F, P = K, T = Q;
    return r(v)(r(_).evaluationCategoryGet) ? (t(), i(P, { key: 0, shadow: "always" }, { header: s(() => [C("div", Y, [a[1] || (a[1] = C("span", { class: "card-title" }, "评价分类", -1)), r(v)(r(_).evaluationCategoryEdit) ? (t(), i(l, { key: 0, disabled: V.value, loading: u.value, size: "default", type: "success", onClick: D }, { default: s(() => a[0] || (a[0] = [I(" 保存 ")])), _: 1, __: [0] }, 8, ["disabled", "loading"])) : p("", true)])]), default: s(() => [L((t(), i(O, { data: o.value, "max-height": A.tableMaxHeight, border: "", style: { width: "100%" } }, { default: s(() => [k(y, { align: "center", label: "序号", type: "index", width: "60" }), k(y, { label: "分类名称", "min-width": "220", prop: "name", "show-overflow-tooltip": "" }, { default: s(({ row: n }) => [n.editing ? (t(), i(J, { key: 0, modelValue: n.name, "onUpdate:modelValue": (f) => n.name = f, modelModifiers: { trim: true }, maxlength: "50", placeholder: "请输入分类名称" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (t(), U("span", Z, $(n.name), 1))]), _: 1 }), r(v)(r(_).evaluationCategoryEdit) ? (t(), i(y, { key: 0, align: "center", label: "操作", width: "80" }, { default: s(({ row: n }) => [n.editing ? (t(), i(l, { key: 1, icon: "el-icon-close", size: "mini", type: "info", onClick: (f) => S(n) }, null, 8, ["onClick"])) : (t(), i(l, { key: 0, icon: "el-icon-edit", size: "mini", type: "primary", onClick: (f) => M(n) }, null, 8, ["onClick"]))]), _: 1 })) : p("", true)]), _: 1 }, 8, ["data", "max-height"])), [[T, c.value]])]), _: 1 })) : p("", true);
  };
} }, oe = R(ee, [["__scopeId", "data-v-ec0bbb20"]]);
export {
  oe as default
};
