import { ref as w } from "vue";
import { reactive as x } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as R } from "vue";
import { createVNode as t } from "vue";
import { withCtx as o } from "vue";
import { unref as c } from "vue";
import { createBlock as f } from "vue";
import { createTextVNode as $ } from "vue";
import { createCommentVNode as y } from "vue";
import { createElementVNode as h } from "vue";
import { toDisplayString as E } from "vue";
import { Fragment as F } from "vue";
import { ElMessage as z } from "element-plus";
import { ElCol as I } from "element-plus";
import { ElRow as G } from "element-plus";
import { ElButton as H } from "element-plus";
import { ElTableColumn as O } from "element-plus";
import { ElSwitch as q } from "element-plus";
import { ElPopconfirm as J } from "element-plus";
import { ElTable as K } from "element-plus";
import { ElPagination as Q } from "element-plus";
import { ElCard as W } from "element-plus";
import X from "./bond-dialog.vue.js";
import { g as Y, e as Z, d as ee } from "../../../../../modules/management-config-46730d2f.js";
import { m as v } from "../../../../../modules/contract-9b18cc88.js";
import { _ as te, dp as ae, G as C } from "../../../../../shared/runtime.js";
const oe = { __name: "bond", setup(le) {
  const B = w(""), b = [{ label: "自营", value: 1 }, { label: "合营", value: 2 }, { label: "内包制", value: 3 }], m = x({ tableList: [], total: 0 }), p = x({ pageNumber: 1, pageSize: 5 }), u = async (n) => {
    try {
      const { content: e, totalElements: s } = await Y({ ...p, ...n });
      e.forEach((r) => {
        r.projectAttribute && b.forEach((d, i) => {
          d.value === r.projectAttribute && (r.projectAttribute = b[i].label);
        });
      }), m.tableList = e, m.total = s;
    } catch (e) {
      console.log(e);
    }
  };
  u();
  const l = w(null), k = () => {
    l.value.Title = "创建项目保证金", l.value.dialogVisible = true, l.value.openType = "add";
  }, S = (n) => {
    l.value.Title = "编辑项目保证金", l.value.dialogVisible = true, l.value.tableList[0] = n, l.value.openType = "edit";
  }, T = async (n) => {
    const e = { ...n };
    typeof e.projectAttribute != "number" && b.forEach((s) => {
      s.label === e.projectAttribute && (e.projectAttribute = s.value);
    });
    try {
      await Z({ id: e.id, status: e.status }), z({ showClose: true, message: "修改状态成功", type: "success" });
    } catch {
    }
  }, V = async (n) => {
    await ee([n.id]), z({ showClose: true, message: "删除成功", type: "success", duration: 1500 }), await u();
  }, j = () => {
    l.value.dialogVisible = false, u();
  }, A = () => {
    u();
  }, D = () => {
    u();
  };
  return (n, e) => {
    const s = I, r = G, d = H, i = O, N = q, M = J, P = K, L = Q, U = W;
    return g(), R(F, null, [t(U, { "body-style": { padding: "20px" }, shadow: "always" }, { default: o(() => [t(r, { class: "header-row" }, { default: o(() => [t(s, null, { default: o(() => [t(ae, { headerTitle: "项目保证金" })]), _: 1 })]), _: 1 }), c(C)(c(v).add) ? (g(), f(r, { key: 0, class: "btn-row" }, { default: o(() => [t(s, { span: 3 }, { default: o(() => [t(d, { icon: "el-icon-plus", type: "primary", onClick: k }, { default: o(() => e[2] || (e[2] = [$("创建项目保证金")])), _: 1, __: [2] })]), _: 1 })]), _: 1 })) : y("", true), t(r, null, { default: o(() => [t(P, { data: m.tableList, "empty-text": B.value, border: "", "max-height": "800" }, { default: o(() => [t(i, { align: "center", label: "序号", "min-width": "60", type: "index" }), t(i, { align: "center", label: "项目类型", prop: "projectAttribute", width: "100" }), t(i, { align: "center", label: "合同额（元）", "min-width": "120", prop: "amountMax" }, { default: o((a) => [h("span", null, E(a.row.amountMin), 1), e[3] || (e[3] = h("span", null, " ~ ", -1)), h("span", null, E(a.row.amountMax), 1)]), _: 1 }), t(i, { align: "center", label: "保证金（元）", "min-width": "120", prop: "cashDeposit" }), t(i, { align: "center", label: "状态", prop: "status", width: "100" }, { default: o(({ row: a }) => [t(N, { modelValue: a.status, "onUpdate:modelValue": (_) => a.status = _, "active-value": 0, "inactive-value": 1, "active-color": "#139212", onChange: (_) => T(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 }), t(i, { align: "center", label: "操作", width: "140" }, { default: o((a) => [c(C)(c(v).edit) ? (g(), f(d, { key: 0, icon: "el-icon-edit", size: "default", type: "primary", onClick: (_) => S(a.row) }, null, 8, ["onClick"])) : y("", true), t(M, { "hide-icon": "", title: "确定删除本条数据吗?", onConfirm: (_) => V(a.row) }, { reference: o(() => [c(C)(c(v).del) ? (g(), f(d, { key: 0, icon: "el-icon-delete", size: "default", type: "danger" })) : y("", true)]), _: 2 }, 1032, ["onConfirm"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text"])]), _: 1 }), t(L, { "current-page": p.pageNumber, "onUpdate:currentPage": e[0] || (e[0] = (a) => p.pageNumber = a), "page-size": p.pageSize, "onUpdate:pageSize": e[1] || (e[1] = (a) => p.pageSize = a), "page-sizes": [5, 10, 15, 20], total: m.total, layout: "total, sizes, prev, pager, next, jumper", style: { "margin-top": "10px" }, onSizeChange: A, onCurrentChange: D }, null, 8, ["current-page", "page-size", "total"])]), _: 1 }), t(X, { ref_key: "dialogRef", ref: l, onClose: j }, null, 512)], 64);
  };
} }, pe = te(oe, [["__scopeId", "data-v-698b0a47"]]);
export {
  pe as default
};
