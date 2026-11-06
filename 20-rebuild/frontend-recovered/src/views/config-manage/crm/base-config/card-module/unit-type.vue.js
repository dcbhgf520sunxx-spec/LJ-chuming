import { ref as _ } from "vue";
import { onMounted as j } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as m } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as E } from "vue";
import { unref as p } from "vue";
import { createBlock as u } from "vue";
import { createTextVNode as h } from "vue";
import { createCommentVNode as f } from "vue";
import { toDisplayString as T } from "vue";
import { ElMessage as L } from "element-plus";
import { ElTableColumn as R } from "element-plus";
import { ElInput as Y } from "element-plus";
import { ElCard as $ } from "element-plus";
import { g as A, s as H } from "../../../../../modules/base-config-98ce5914.js";
import { G as g, dt as U, aw as J, V as w, aI as K } from "../../../../../shared/runtime.js";
const Q = { class: "clearfix" }, W = { key: 1 }, X = { key: 1 }, ae = { __name: "unit-type", props: { permission: { type: Object, default: () => {
} } }, setup(d) {
  const x = d, t = _(false), i = _([]), k = _([]), v = _(false);
  j(() => {
    V();
  });
  const B = { name: [{ required: true, message: "请填写单位类别", trigger: "change" }], sort: [{ required: true, message: "请填写排序", trigger: "change" }] }, { tableValidate: N, cleanUpData: z, wrongCellMask: D } = J({ rules: B });
  async function V() {
    if (g(x.permission.getUnitType)) try {
      const a = await A({ crmBasicsConfigEnum: U.UNIT_TYPE_CONFIG.V });
      i.value = a[0].crmBasicsConfigDTOS;
    } catch (a) {
      console.log(a);
    }
  }
  function I() {
    t.value = true, k.value = w(i.value);
  }
  function S(a) {
    const e = w({});
    e.uid = K(), a.push(e);
  }
  function O(a) {
    i.value.splice(a, 1);
  }
  function q() {
    i.value = k.value, t.value = false;
  }
  async function F() {
    const { validResult: a, dealList: e } = N(i.value);
    if (!a) return;
    const o = z(e), c = o == null ? void 0 : o.map((r) => ({ id: r.id, name: r.name, sort: r.sort }));
    try {
      v.value = true, await H({ crmBasicsConfigEnum: U.UNIT_TYPE_CONFIG.V }, c), L.success("单位类别配置成功"), t.value = false, V();
    } catch (r) {
      console.log(r, "单位类别保存");
    } finally {
      v.value = false;
    }
  }
  return (a, e) => {
    const o = C("common-button"), c = R, r = Y, G = C("common-input-number"), M = C("common-table"), P = $;
    return n(), b("div", null, [m(P, { class: "config-list-card", style: { height: "400px" } }, { header: s(() => [E("div", Q, [e[4] || (e[4] = E("span", { class: "card-title" }, "单位类别配置", -1)), !t.value && p(g)(d.permission.editUnitType) ? (n(), u(o, { key: 0, style: { float: "right" }, type: "primary", size: "small", onClick: I }, { default: s(() => e[1] || (e[1] = [h("编辑")])), _: 1, __: [1] })) : f("", true), t.value && p(g)(d.permission.saveUnitType) ? (n(), u(o, { key: 1, style: { float: "right", "margin-left": "8px" }, type: "success", size: "small", loading: v.value, onClick: F }, { default: s(() => e[2] || (e[2] = [h(" 保存 ")])), _: 1, __: [2] }, 8, ["loading"])) : f("", true), t.value && p(g)(d.permission.addUnitType) ? (n(), u(o, { key: 2, icon: "el-icon-plus", style: { float: "right", "margin-left": "8px" }, type: "warning", size: "small", onClick: e[0] || (e[0] = (l) => S(i.value)) })) : f("", true), t.value ? (n(), u(o, { key: 3, style: { float: "right" }, type: "info", size: "small", onClick: q }, { default: s(() => e[3] || (e[3] = [h("取消编辑")])), _: 1, __: [3] })) : f("", true)])]), default: s(() => [m(M, { data: i.value, showEmptySymbol: false, "return-source-data": "", "max-height": 290, "cell-class-name": p(D) }, { default: s(() => [m(c, { type: "index", align: "center", label: "序号", width: "60" }), m(c, { align: "center", label: "类别", prop: "name", "show-overflow-tooltip": true }, { default: s(({ row: l }) => [t.value ? (n(), u(r, { key: 0, modelValue: l.name, "onUpdate:modelValue": (y) => l.name = y, maxlength: "50", size: "small", class: "input-border-none", placeholder: "填写单位类别" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), b("span", W, T(l.name), 1))]), _: 1 }), m(c, { align: "center", label: "排序", width: "130", prop: "sort", "show-overflow-tooltip": true }, { default: s(({ row: l }) => [t.value ? (n(), u(G, { key: 0, modelValue: l.sort, "onUpdate:modelValue": (y) => l.sort = y, min: 1, size: "small", class: "input-border-none", placeholder: "填写排序" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), b("span", X, T(l.sort), 1))]), _: 1 }), m(c, { align: "center", label: "操作", width: "100" }, { default: s(({ $index: l }) => [t.value && p(g)(d.permission.delUnitType) ? (n(), u(o, { key: 0, icon: "el-icon-delete", type: "danger", size: "small", onClick: (y) => O(l) }, null, 8, ["onClick"])) : f("", true)]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name"])]), _: 1 })]);
  };
} };
export {
  ae as default
};
