import { ref as v } from "vue";
import { computed as x } from "vue";
import { resolveComponent as p } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as L } from "vue";
import { createVNode as o } from "vue";
import { withCtx as l } from "vue";
import { unref as s } from "vue";
import { createBlock as _ } from "vue";
import { createElementVNode as Q } from "vue";
import { createTextVNode as f } from "vue";
import { withDirectives as C } from "vue";
import { ElNotification as $ } from "element-plus";
import { ElTableColumn as S } from "element-plus";
import { ElForm as J } from "element-plus";
import { ElCard as W } from "element-plus";
import { ElTag as X } from "element-plus";
import { ElCol as Y } from "element-plus";
import { vLoading as Z } from "element-plus";
import { c as ee } from "../../../../../modules/project-config-5f01cdbc.js";
import { _ as te, x as ae, o as oe, fg as le, G as ne, ff as j, fh as ie, aw as se, i as de } from "../../../../../shared/runtime.js";
const re = { class: "button-list" }, ce = { key: 1 }, ue = { __name: "index", setup(me) {
  const b = v(), c = v(false), { crud: a, CRUD: g } = ae({ title: "配套件关联物料配置-项目配置", sort: [], dataPath: "", crudApi: { ...ee }, hasPagination: false }, b), { maxHeight: I } = oe({ extraBox: [".el-tabs__header", ".el-card__header"], paginate: false, extraHeight: 50 }), { projectTree: V } = le(), h = x(() => a.data.map((e) => e.projectId)), y = x(() => V.value.map((e) => (e.serialNumberName = e.serialNumber + " " + e.name, e)));
  function N(e) {
    var t, n;
    return (t = h.value) != null && t.length ? (n = y.value) == null ? void 0 : n.filter((d) => !h.value.includes(d.id) || d.id === e.projectId) : y.value;
  }
  g.HOOK.beforeToQuery = async (e) => {
    e.query.boolGeneralConfig = false;
  }, g.HOOK.handleRefresh = (e, t) => {
    t.data = t.data.detailList, console.log(e.data, t.data);
  };
  const E = /* @__PURE__ */ new Map([["boolLink", -1]]), B = { projectId: [{ required: true, message: "请选择项目", trigger: "change" }], boolLink: [{ required: true, message: "请选择配置", trigger: "change" }] }, { tableValidate: D, cleanUpData: R, wrongCellMask: U } = se({ rules: B, ditto: E });
  function k() {
    if (a.data.length > 0) {
      const e = a.data[0];
      (!de(e.boolLink) || e.boolLink === -1) && (e.boolLink = void 0);
    }
  }
  function T() {
    a.data.push({ rowKey: Date.now(), projectId: void 0, boolLink: a.data.length === 0 ? void 0 : -1 }), k();
  }
  function M(e) {
    const t = a.data.findIndex((n) => n.rowKey === e.rowKey);
    t !== -1 && (a.data.splice(t, 1), k());
  }
  async function O() {
    try {
      c.value = true;
      let e = [];
      if (a.data.length > 0) {
        const { validResult: t, dealList: n } = D(a.data);
        if (!t) return c.value = false, t;
        R(n), e = a.data.map((d) => ({ projectId: d.projectId, boolLink: d.boolLink }));
      }
      await a.crudApi.add({ boolGeneralConfig: false, detailList: e }), $({ title: "保存成功", type: "success", duration: 2500 }), a.toQuery();
    } catch (e) {
      console.log(e);
    } finally {
      c.value = false;
    }
  }
  return (e, t) => {
    const n = p("common-button"), d = p("common-tip-button"), u = S, w = p("common-select-v2"), A = p("common-table"), H = J, K = W, q = X, z = Y, P = G("permission"), F = Z;
    return r(), L("div", null, [o(z, { span: 12 }, { default: l(() => [s(ne)(s(j).get) ? (r(), _(K, { key: 0, shadow: "always" }, { header: l(() => [Q("div", re, [o(n, { icon: "el-icon-plus", size: "default", type: "primary", onClick: T }, { default: l(() => t[0] || (t[0] = [f(" 添加 ")])), _: 1, __: [0] }), C((r(), _(d, { loading: c.value, disabled: e.submitDisabled, "show-tip": "", size: "default", type: "success", style: { "margin-left": "10px" }, onClick: O }, { default: l(() => t[1] || (t[1] = [f(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[P, s(j).edit]])])]), default: l(() => [o(H, null, { default: l(() => [C((r(), _(A, { ref_key: "tableRef", ref: b, data: s(a).data, "max-height": s(I), "cell-class-name": s(U), "return-source-data": "", "show-empty-symbol": false, style: { width: "100%" } }, { default: l(() => [o(u, { label: "序号", type: "index", align: "center", width: "60" }), o(u, { label: "项目", prop: "projectId", key: "projectId", align: "center" }, { default: l((i) => [o(w, { modelValue: i.row.projectId, "onUpdate:modelValue": (m) => i.row.projectId = m, options: N(i.row), type: "other", "data-structure": { key: "id", label: "serialNumberName", value: "id" }, clearable: "", filterable: "", style: { width: "100%" }, placeholder: "选择项目" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 1 }), o(u, { label: "配置", prop: "boolLink", key: "boolLink", align: "center", width: "200px" }, { default: l((i) => [o(w, { modelValue: i.row.boolLink, "onUpdate:modelValue": (m) => i.row.boolLink = m, options: s(ie).ENUM, type: "enum", clearable: "", placeholder: "选择配置", "show-extra": i.$index !== 0, class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra"])]), _: 1 }), o(u, { label: "操作", align: "center", width: "100px" }, { default: l((i) => [o(n, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (m) => M(i.row) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[F, s(a).loading]])]), _: 1 })]), _: 1 })) : (r(), L("div", ce, [o(q, { type: "warning", size: "large" }, { default: l(() => t[2] || (t[2] = [f(" *暂无权限")])), _: 1, __: [2] })]))]), _: 1 })]);
  };
} }, be = te(ue, [["__scopeId", "data-v-dd9c2d05"]]);
export {
  be as default
};
