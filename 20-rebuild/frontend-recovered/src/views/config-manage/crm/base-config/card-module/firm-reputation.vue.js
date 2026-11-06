import { ref as _ } from "vue";
import { onMounted as j } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as m } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as E } from "vue";
import { unref as p } from "vue";
import { createBlock as u } from "vue";
import { createTextVNode as C } from "vue";
import { createCommentVNode as f } from "vue";
import { toDisplayString as B } from "vue";
import { ElMessage as A } from "element-plus";
import { ElTableColumn as L } from "element-plus";
import { ElInput as $ } from "element-plus";
import { ElCard as G } from "element-plus";
import { g as H, s as J } from "../../../../../modules/base-config-98ce5914.js";
import { G as g, dt as w, aw as K, V as x, aI as Q } from "../../../../../shared/runtime.js";
const W = { class: "clearfix" }, X = { key: 1 }, Y = { key: 1 }, ae = { __name: "firm-reputation", props: { permission: { type: Object, default: () => {
} } }, setup(d) {
  const T = d, t = _(false), i = _([]), h = _([]), k = _(false);
  j(() => {
    V();
  });
  const P = { name: [{ required: true, message: "请填写信誉等级", trigger: "change" }], sort: [{ required: true, message: "请填写排序", trigger: "change" }] }, { tableValidate: U, cleanUpData: z, wrongCellMask: D } = K({ rules: P });
  async function V() {
    if (g(T.permission.getBusinessPrestige)) try {
      const a = await H({ crmBasicsConfigEnum: w.FIRM_REPUTATION.V });
      i.value = a[0].crmBasicsConfigDTOS;
    } catch (a) {
      console.log(a);
    }
  }
  function I() {
    t.value = true, h.value = x(i.value);
  }
  function N(a) {
    const e = x({});
    e.uid = Q(), a.push(e);
  }
  function R(a) {
    i.value.splice(a, 1);
  }
  function M() {
    i.value = h.value, t.value = false;
  }
  async function S() {
    const { validResult: a, dealList: e } = U(i.value);
    if (!a) return;
    const n = z(e), c = n == null ? void 0 : n.map((r) => ({ id: r.id, name: r.name, sort: r.sort }));
    try {
      await J({ crmBasicsConfigEnum: w.FIRM_REPUTATION.V }, c), A.success("企业信誉配置成功"), t.value = false, V();
    } catch (r) {
      console.log(r, "企业信誉保存");
    } finally {
      k.value = false;
    }
  }
  return (a, e) => {
    const n = v("common-button"), c = L, r = $, O = v("common-input-number"), q = v("common-table"), F = G;
    return s(), b("div", null, [m(F, { class: "config-list-card", style: { height: "400px" } }, { header: o(() => [E("div", W, [e[4] || (e[4] = E("span", { class: "card-title" }, "企业信誉", -1)), !t.value && p(g)(d.permission.editBusinessPrestige) ? (s(), u(n, { key: 0, style: { float: "right" }, type: "primary", size: "small", onClick: I }, { default: o(() => e[1] || (e[1] = [C("编辑")])), _: 1, __: [1] })) : f("", true), t.value && p(g)(d.permission.savBusinessPrestige) ? (s(), u(n, { key: 1, style: { float: "right", "margin-left": "8px" }, type: "success", size: "small", loading: k.value, onClick: S }, { default: o(() => e[2] || (e[2] = [C(" 保存 ")])), _: 1, __: [2] }, 8, ["loading"])) : f("", true), t.value && p(g)(d.permission.addBusinessPrestige) ? (s(), u(n, { key: 2, icon: "el-icon-plus", style: { float: "right", "margin-left": "8px" }, type: "warning", size: "small", onClick: e[0] || (e[0] = (l) => N(i.value)) })) : f("", true), t.value ? (s(), u(n, { key: 3, style: { float: "right" }, type: "info", size: "small", onClick: M }, { default: o(() => e[3] || (e[3] = [C("取消编辑")])), _: 1, __: [3] })) : f("", true)])]), default: o(() => [m(q, { data: i.value, showEmptySymbol: false, "return-source-data": "", "max-height": 290, "cell-class-name": p(D) }, { default: o(() => [m(c, { type: "index", align: "center", label: "序号", width: "60" }), m(c, { align: "center", label: "信誉等级", prop: "name", "show-overflow-tooltip": true }, { default: o(({ row: l }) => [t.value ? (s(), u(r, { key: 0, modelValue: l.name, "onUpdate:modelValue": (y) => l.name = y, maxlength: "50", size: "small", class: "input-border-none", placeholder: "填写信誉等级" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (s(), b("span", X, B(l.name), 1))]), _: 1 }), m(c, { align: "center", label: "排序", width: "130", prop: "sort", "show-overflow-tooltip": true }, { default: o(({ row: l }) => [t.value ? (s(), u(O, { key: 0, modelValue: l.sort, "onUpdate:modelValue": (y) => l.sort = y, min: 1, size: "small", class: "input-border-none", placeholder: "填写排序" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (s(), b("span", Y, B(l.sort), 1))]), _: 1 }), m(c, { align: "center", label: "操作", width: "100" }, { default: o(({ $index: l }) => [t.value && p(g)(d.permission.delBusinessPrestige) ? (s(), u(n, { key: 0, icon: "el-icon-delete", type: "danger", size: "small", onClick: (y) => R(l) }, null, 8, ["onClick"])) : f("", true)]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name"])]), _: 1 })]);
  };
} };
export {
  ae as default
};
