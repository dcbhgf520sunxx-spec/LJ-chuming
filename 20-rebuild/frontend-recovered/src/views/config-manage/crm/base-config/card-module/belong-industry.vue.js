import { ref as _ } from "vue";
import { onMounted as M } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as C } from "vue";
import { createVNode as m } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as E } from "vue";
import { unref as p } from "vue";
import { createBlock as u } from "vue";
import { createTextVNode as h } from "vue";
import { createCommentVNode as f } from "vue";
import { toDisplayString as w } from "vue";
import { ElMessage as j } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElInput as $ } from "element-plus";
import { ElCard as P } from "element-plus";
import { g as A, s as H } from "../../../../../modules/base-config-98ce5914.js";
import { G as g, dt as x, aw as J, V as B, aI as K } from "../../../../../shared/runtime.js";
const Q = { class: "clearfix" }, W = { key: 1 }, X = { key: 1 }, ae = { __name: "belong-industry", props: { permission: { type: Object, default: () => {
} } }, setup(d) {
  const I = d, t = _(false), i = _([]), k = _([]), v = _(false);
  M(() => {
    V();
  });
  const N = { name: [{ required: true, message: "请填写所属行业", trigger: "change" }], sort: [{ required: true, message: "请填写排序", trigger: "change" }] }, { tableValidate: D, cleanUpData: U, wrongCellMask: z } = J({ rules: N });
  async function V() {
    if (g(I.permission.getIndustry)) try {
      const a = await A({ crmBasicsConfigEnum: x.BELONG_INDUSTRY_CONFIG.V });
      i.value = a[0].crmBasicsConfigDTOS;
    } catch (a) {
      console.log(a);
    }
  }
  function S() {
    t.value = true, k.value = B(i.value);
  }
  function T(a) {
    const e = B({});
    e.uid = K(), a.push(e);
  }
  function O(a) {
    i.value.splice(a, 1);
  }
  function G() {
    i.value = k.value, t.value = false;
  }
  async function L() {
    const { validResult: a, dealList: e } = D(i.value);
    if (!a) return;
    const s = U(e), c = s == null ? void 0 : s.map((r) => ({ id: r.id, name: r.name, sort: r.sort }));
    try {
      v.value = true, await H({ crmBasicsConfigEnum: x.BELONG_INDUSTRY_CONFIG.V }, c), j.success("所属行业配置成功"), t.value = false, V();
    } catch (r) {
      console.log(r, "所属行业保存");
    } finally {
      v.value = false;
    }
  }
  return (a, e) => {
    const s = b("common-button"), c = Y, r = $, R = b("common-input-number"), q = b("common-table"), F = P;
    return n(), C("div", null, [m(F, { class: "config-list-card", style: { height: "400px" } }, { header: o(() => [E("div", Q, [e[4] || (e[4] = E("span", { class: "card-title" }, "所属行业配置", -1)), !t.value && p(g)(d.permission.editIndustry) ? (n(), u(s, { key: 0, style: { float: "right" }, type: "primary", size: "small", onClick: S }, { default: o(() => e[1] || (e[1] = [h("编辑")])), _: 1, __: [1] })) : f("", true), t.value && p(g)(d.permission.savIndustry) ? (n(), u(s, { key: 1, style: { float: "right", "margin-left": "8px" }, type: "success", size: "small", onClick: L, loading: v.value }, { default: o(() => e[2] || (e[2] = [h(" 保存 ")])), _: 1, __: [2] }, 8, ["loading"])) : f("", true), t.value && p(g)(d.permission.addIndustry) ? (n(), u(s, { key: 2, icon: "el-icon-plus", style: { float: "right", "margin-left": "8px" }, type: "warning", size: "small", onClick: e[0] || (e[0] = (l) => T(i.value)) })) : f("", true), t.value ? (n(), u(s, { key: 3, style: { float: "right" }, type: "info", size: "small", onClick: G }, { default: o(() => e[3] || (e[3] = [h("取消编辑")])), _: 1, __: [3] })) : f("", true)])]), default: o(() => [m(q, { data: i.value, showEmptySymbol: false, "return-source-data": "", "max-height": 290, "cell-class-name": p(z) }, { default: o(() => [m(c, { type: "index", align: "center", label: "序号", width: "60" }), m(c, { align: "center", label: "类别", prop: "name", "show-overflow-tooltip": true }, { default: o(({ row: l }) => [t.value ? (n(), u(r, { key: 0, modelValue: l.name, "onUpdate:modelValue": (y) => l.name = y, maxlength: "50", size: "small", class: "input-border-none", placeholder: "填写所属行业" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), C("span", W, w(l.name), 1))]), _: 1 }), m(c, { align: "center", label: "排序", width: "130", prop: "sort", "show-overflow-tooltip": true }, { default: o(({ row: l }) => [t.value ? (n(), u(R, { key: 0, modelValue: l.sort, "onUpdate:modelValue": (y) => l.sort = y, min: 1, size: "small", class: "input-border-none", placeholder: "填写排序" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), C("span", X, w(l.sort), 1))]), _: 1 }), m(c, { align: "center", label: "操作", width: "100" }, { default: o(({ $index: l }) => [t.value && p(g)(d.permission.delIndustry) ? (n(), u(s, { key: 0, icon: "el-icon-delete", type: "danger", size: "small", onClick: (y) => O(l) }, null, 8, ["onClick"])) : f("", true)]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name"])]), _: 1 })]);
  };
} };
export {
  ae as default
};
