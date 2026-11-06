import { ref as _ } from "vue";
import { onMounted as M } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as C } from "vue";
import { createVNode as m } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as E } from "vue";
import { unref as p } from "vue";
import { createBlock as u } from "vue";
import { createTextVNode as b } from "vue";
import { createCommentVNode as f } from "vue";
import { toDisplayString as U } from "vue";
import { ElMessage as j } from "element-plus";
import { ElTableColumn as A } from "element-plus";
import { ElInput as L } from "element-plus";
import { ElCard as $ } from "element-plus";
import { g as P, s as H } from "../../../../../modules/base-config-98ce5914.js";
import { G as g, dt as w, aw as J, V as x, aI as K } from "../../../../../shared/runtime.js";
const W = { class: "clearfix" }, X = { key: 1 }, Y = { key: 1 }, ae = { __name: "unit-nature", props: { permission: { type: Object, default: () => {
} } }, setup(d) {
  const N = d, t = _(false), i = _([]), h = _([]), k = _(false);
  M(() => {
    V();
  });
  const B = { name: [{ required: true, message: "请填写性质名称", trigger: "change" }], sort: [{ required: true, message: "请填写排序", trigger: "change" }] }, { tableValidate: T, cleanUpData: z, wrongCellMask: D } = J({ rules: B });
  async function V() {
    if (g(N.permission.getUnitQuality)) try {
      const a = await P({ crmBasicsConfigEnum: w.UNIT_NATURE_CONFIG.V });
      i.value = a[0].crmBasicsConfigDTOS;
    } catch (a) {
      console.log(a);
    }
  }
  function I() {
    t.value = true, h.value = x(i.value);
  }
  function Q(a) {
    const e = x({});
    e.uid = K(), a.push(e);
  }
  function S(a) {
    i.value.splice(a, 1);
  }
  function O() {
    i.value = h.value, t.value = false;
  }
  async function R() {
    const { validResult: a, dealList: e } = T(i.value);
    if (!a) return;
    const o = z(e), c = o == null ? void 0 : o.map((r) => ({ id: r.id, name: r.name, sort: r.sort }));
    try {
      await H({ crmBasicsConfigEnum: w.UNIT_NATURE_CONFIG.V }, c), j.success("单位性质配置成功"), t.value = false, V();
    } catch (r) {
      console.log(r, "单位性质保存");
    } finally {
      k.value = false;
    }
  }
  return (a, e) => {
    const o = v("common-button"), c = A, r = L, q = v("common-input-number"), F = v("common-table"), G = $;
    return n(), C("div", null, [m(G, { class: "config-list-card", style: { height: "400px" } }, { header: s(() => [E("div", W, [e[4] || (e[4] = E("span", { class: "card-title" }, "单位性质配置", -1)), !t.value && p(g)(d.permission.editUnitQuality) ? (n(), u(o, { key: 0, style: { float: "right" }, type: "primary", size: "small", onClick: I }, { default: s(() => e[1] || (e[1] = [b("编辑")])), _: 1, __: [1] })) : f("", true), t.value && p(g)(d.permission.saveUnitQuality) ? (n(), u(o, { key: 1, style: { float: "right", "margin-left": "8px" }, type: "success", size: "small", loading: k.value, onClick: R }, { default: s(() => e[2] || (e[2] = [b(" 保存 ")])), _: 1, __: [2] }, 8, ["loading"])) : f("", true), t.value && p(g)(d.permission.addUnitQuality) ? (n(), u(o, { key: 2, icon: "el-icon-plus", style: { float: "right", "margin-left": "8px" }, type: "warning", size: "small", onClick: e[0] || (e[0] = (l) => Q(i.value)) })) : f("", true), t.value ? (n(), u(o, { key: 3, style: { float: "right" }, type: "info", size: "small", onClick: O }, { default: s(() => e[3] || (e[3] = [b("取消编辑")])), _: 1, __: [3] })) : f("", true)])]), default: s(() => [m(F, { data: i.value, showEmptySymbol: false, "return-source-data": "", "max-height": 290, "cell-class-name": p(D) }, { default: s(() => [m(c, { type: "index", align: "center", label: "序号", width: "60" }), m(c, { align: "center", label: "性质", prop: "name", "show-overflow-tooltip": true }, { default: s(({ row: l }) => [t.value ? (n(), u(r, { key: 0, modelValue: l.name, "onUpdate:modelValue": (y) => l.name = y, maxlength: "50", size: "small", class: "input-border-none", placeholder: "填写单位性质" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), C("span", X, U(l.name), 1))]), _: 1 }), m(c, { align: "center", label: "排序", width: "130", prop: "sort", "show-overflow-tooltip": true }, { default: s(({ row: l }) => [t.value ? (n(), u(q, { key: 0, modelValue: l.sort, "onUpdate:modelValue": (y) => l.sort = y, min: 1, size: "small", class: "input-border-none", placeholder: "填写排序" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), C("span", Y, U(l.sort), 1))]), _: 1 }), m(c, { align: "center", label: "操作", width: "100" }, { default: s(({ $index: l }) => [t.value && p(g)(d.permission.delUnitQuality) ? (n(), u(o, { key: 0, icon: "el-icon-delete", type: "danger", size: "small", onClick: (y) => S(l) }, null, 8, ["onClick"])) : f("", true)]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name"])]), _: 1 })]);
  };
} };
export {
  ae as default
};
