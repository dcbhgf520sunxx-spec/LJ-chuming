import { ref as f } from "vue";
import { onMounted as L } from "vue";
import { computed as m } from "vue";
import { resolveComponent as U } from "vue";
import { unref as r } from "vue";
import { openBlock as l } from "vue";
import { createBlock as o } from "vue";
import { withCtx as c } from "vue";
import { createElementVNode as b } from "vue";
import { createTextVNode as j } from "vue";
import { createCommentVNode as h } from "vue";
import { withDirectives as F } from "vue";
import { createVNode as p } from "vue";
import { createElementBlock as $ } from "vue";
import { toDisplayString as K } from "vue";
import { ElMessage as x } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { ElInput as X } from "element-plus";
import { ElTable as Y } from "element-plus";
import { ElCard as Z } from "element-plus";
import { vLoading as ee } from "element-plus";
import { _ as ne, G as y, fT as v } from "../../../../../shared/runtime.js";
import { c as ie, d as ae } from "../../../../../modules/supplier-evaluation-config-2fb6916b.js";
const te = { class: "card-header" }, le = { key: 1 }, oe = { class: "table-op" }, se = { __name: "qualification-config", props: { tableMaxHeight: { type: Number, default: void 0 } }, setup(D) {
  const u = f(false), d = f(false), i = f([]), k = f([]);
  L(() => {
    E();
  });
  const S = m(() => i.value.map((e) => ({ id: e.id ?? null, name: e.name || "" }))), V = m(() => k.value.map((e) => ({ id: e.id ?? null, name: e.name || "" }))), C = m(() => JSON.stringify(S.value) !== JSON.stringify(V.value)), q = m(() => u.value || d.value || !C.value);
  async function E() {
    u.value = true;
    try {
      const e = await ie();
      i.value = J(e), !i.value.length && y(v.qualificationEdit) && (i.value = [w(true)]), k.value = I(i.value);
    } catch (e) {
      console.log("供应商评价配置-供应商资质列表", e);
    } finally {
      u.value = false;
    }
  }
  function z(e) {
    i.value.splice(e + 1, 0, w(true));
  }
  function M(e) {
    A(e) || i.value.splice(e, 1);
  }
  function A(e) {
    if (i.value.length !== 1 || e !== 0) return false;
    const n = i.value[0] || {};
    return !String(n.name || "").trim();
  }
  function N(e) {
    const n = i.value[e] || {};
    return !!n.editing && !String(n.name || "").trim();
  }
  async function B() {
    if (!C.value) return;
    if (i.value.some((n) => !n.name)) {
      x.error("请填写完整的供应商资质名称");
      return;
    }
    d.value = true;
    try {
      await ae(i.value.map((n) => ({ id: n.id, name: n.name }))), x.success("供应商资质配置保存成功");
    } catch (n) {
      console.log("供应商评价配置-供应商资质保存", n);
    } finally {
      try {
        await E();
      } catch (n) {
        console.log("供应商评价配置-供应商资质刷新", n);
      }
      d.value = false;
    }
  }
  function J(e) {
    return T(e).map((a) => ({ id: a.id, name: a.name || "", editing: false, backupName: a.name || "" }));
  }
  function w(e = false) {
    return { id: void 0, name: "", editing: e, backupName: "" };
  }
  function O(e) {
    e.backupName = e.name || "", e.editing = true;
  }
  function P(e) {
    const n = i.value.findIndex((a) => a === e);
    N(n) || (e.name = e.backupName || "", e.editing = false);
  }
  function T(e) {
    var n;
    return Array.isArray(e) ? e : Array.isArray(e == null ? void 0 : e.content) ? e.content : Array.isArray((n = e == null ? void 0 : e.data) == null ? void 0 : n.content) ? e.data.content : Array.isArray(e == null ? void 0 : e.records) ? e.records : Array.isArray(e == null ? void 0 : e.list) ? e.list : Array.isArray(e == null ? void 0 : e.data) ? e.data : [];
  }
  function I(e) {
    return JSON.parse(JSON.stringify(e));
  }
  return (e, n) => {
    const a = U("common-button"), _ = W, Q = X, R = Y, G = Z, H = ee;
    return r(y)(r(v).qualificationGet) ? (l(), o(G, { key: 0, shadow: "always" }, { header: c(() => [b("div", te, [n[1] || (n[1] = b("span", { class: "card-title" }, "供应商资质配置", -1)), r(y)(r(v).qualificationEdit) ? (l(), o(a, { key: 0, disabled: q.value, loading: d.value, size: "default", type: "success", onClick: B }, { default: c(() => n[0] || (n[0] = [j(" 保存 ")])), _: 1, __: [0] }, 8, ["disabled", "loading"])) : h("", true)])]), default: c(() => [F((l(), o(R, { data: i.value, "max-height": D.tableMaxHeight, border: "", style: { width: "100%" } }, { default: c(() => [p(_, { align: "center", label: "序号", type: "index", width: "60" }), p(_, { label: "供应商资质名称", "min-width": "220", prop: "name", "show-overflow-tooltip": "" }, { default: c(({ row: t }) => [t.editing ? (l(), o(Q, { key: 0, modelValue: t.name, "onUpdate:modelValue": (s) => t.name = s, modelModifiers: { trim: true }, maxlength: "50", placeholder: "请输入供应商资质名称" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (l(), $("span", le, K(t.name), 1))]), _: 1 }), r(y)(r(v).qualificationEdit) ? (l(), o(_, { key: 0, align: "center", label: "操作", width: "170" }, { default: c(({ row: t, $index: s }) => [b("div", oe, [t.editing ? (l(), o(a, { key: 1, disabled: N(s), icon: "el-icon-close", size: "mini", type: "info", onClick: (g) => P(t) }, null, 8, ["disabled", "onClick"])) : (l(), o(a, { key: 0, icon: "el-icon-edit", size: "mini", type: "primary", onClick: (g) => O(t) }, null, 8, ["onClick"])), p(a, { disabled: A(s), icon: "el-icon-delete", size: "mini", type: "danger", onClick: (g) => M(s) }, null, 8, ["disabled", "onClick"]), p(a, { icon: "el-icon-plus", size: "mini", type: "success", onClick: (g) => z(s) }, null, 8, ["onClick"])])]), _: 1 })) : h("", true)]), _: 1 }, 8, ["data", "max-height"])), [[H, u.value]])]), _: 1 })) : h("", true);
  };
} }, de = ne(se, [["__scopeId", "data-v-8e071fc4"]]);
export {
  de as default
};
