import { ref as m } from "vue";
import { resolveComponent as C } from "vue";
import { resolveDirective as J } from "vue";
import { openBlock as r } from "vue";
import { createBlock as p } from "vue";
import { withCtx as s } from "vue";
import { withDirectives as k } from "vue";
import { createTextVNode as v } from "vue";
import { unref as l } from "vue";
import { createVNode as o } from "vue";
import { createElementBlock as g } from "vue";
import { toDisplayString as E } from "vue";
import { isRef as A } from "vue";
import { ElMessage as z } from "element-plus";
import { ElTableColumn as K } from "element-plus";
import { ElInput as O } from "element-plus";
import { ElPagination as Q } from "element-plus";
import { g as W, e as X, d as Y } from "../../../../modules/scrap-ledger-452ee452.js";
import { V as Z } from "../../../../modules/contract-9b18cc88.js";
import { u as ee, J as te, G as ae, o as oe } from "../../../../shared/runtime.js";
import ne from "./add-contract.vue.js";
const le = { key: 1 }, se = { key: 1 }, ie = { key: 0 }, re = { key: 1 }, ge = { __name: "scrap-contract", props: { modelValue: { type: Boolean, default: false } }, emits: ["update:modelValue"], setup(N, { emit: S }) {
  const B = N, d = Z.config, D = S, H = m([["createTime", ["parse-time", "{y}-{m}-{d}"]]]), { visible: f, handleClose: P } = ee({ props: B, emit: D, showHook: u }), { handleSizeChange: R, handleCurrentChange: U, total: L, setTotalPage: T, queryPage: _ } = te({ fetchHook: u }), h = m(false), b = m([]), V = m();
  async function u() {
    if (ae(d.get)) {
      b.value = [];
      try {
        const { content: a, totalElements: t } = await W({ ..._ });
        T(t), console.log(a), a.forEach((n) => {
          n.isEdit = false;
        }), b.value = a;
      } catch (a) {
        console.log(a);
      }
    }
  }
  const { maxHeight: $ } = oe({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], paginate: true, extraHeight: 120, minHeight: 300, navbar: false }, V);
  function w() {
    h.value = true;
  }
  function M() {
    u();
  }
  async function j(a) {
    const t = [], n = { purchaser: a.purchaser, id: a.id, serialNumber: a.serialNumber };
    t.push(n);
    try {
      await X(t), z({ message: "修改成功", type: "success" }), a.isEdit = false, u();
    } catch (i) {
      console.log(i, "配置修改失败");
    }
  }
  async function q(a) {
    const t = [];
    t.push(a.id);
    try {
      await Y(t), z({ message: "删除成功", type: "success" }), u();
    } catch (n) {
      console.log(n, "配置删除失败");
    }
  }
  return (a, t) => {
    const n = C("common-button"), i = K, x = O, F = C("common-table"), I = Q, G = C("common-drawer"), y = J("permission");
    return r(), p(G, { modelValue: l(f), "onUpdate:modelValue": t[1] || (t[1] = (e) => A(f) ? f.value = e : null), "before-close": l(P), size: "100%", title: "合同配置", ref_key: "drawerRef", ref: V }, { titleRight: s(() => [k((r(), p(n, { type: "success", size: "default", onClick: w }, { default: s(() => t[2] || (t[2] = [v("新增")])), _: 1, __: [2] })), [[y, l(d).add]])]), content: s(() => [o(F, { data: b.value, "data-format": H.value, "max-height": l($) }, { default: s(() => [o(i, { label: "序号", align: "center", width: "100", type: "index" }), o(i, { label: "购买方", align: "center", prop: "purchaser" }, { default: s(({ row: e }) => [e.isEdit ? (r(), p(x, { key: 0, modelValue: e.purchaser, "onUpdate:modelValue": (c) => e.purchaser = c }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (r(), g("span", le, E(e.purchaser), 1))]), _: 1 }), o(i, { label: "合同编号", align: "center", prop: "serialNumber" }, { default: s(({ row: e }) => [e.isEdit ? (r(), p(x, { key: 0, modelValue: e.serialNumber, "onUpdate:modelValue": (c) => e.serialNumber = c }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (r(), g("span", se, E(e.serialNumber), 1))]), _: 1 }), o(i, { label: "创建人", align: "center", width: "150", prop: "userName" }), o(i, { label: "创建时间", align: "center", prop: "createTime" }), o(i, { label: "操作", align: "center" }, { default: s(({ row: e }) => [e.isEdit ? (r(), g("div", ie, [o(n, { type: "success", onClick: (c) => j(e), size: "default" }, { default: s(() => t[3] || (t[3] = [v("确认")])), _: 2, __: [3] }, 1032, ["onClick"]), o(n, { type: "danger", onClick: (c) => e.isEdit = false, size: "default" }, { default: s(() => t[4] || (t[4] = [v("取消")])), _: 2, __: [4] }, 1032, ["onClick"])])) : (r(), g("div", re, [k(o(n, { icon: "el-icon-edit", type: "primary", onClick: (c) => e.isEdit = true, size: "default" }, null, 8, ["onClick"]), [[y, l(d).edit]]), k(o(n, { icon: "el-icon-delete", type: "danger", onClick: (c) => q(e), size: "default" }, null, 8, ["onClick"]), [[y, l(d).del]])]))]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"]), o(I, { total: l(L), "current-page": l(_).pageNumber, "page-size": l(_).pageSize, layout: "total, prev, pager, next, sizes", onSizeChange: l(R), onCurrentChange: l(U) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), o(ne, { modelValue: h.value, "onUpdate:modelValue": t[0] || (t[0] = (e) => h.value = e), onSuccess: M }, null, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ge as default
};
