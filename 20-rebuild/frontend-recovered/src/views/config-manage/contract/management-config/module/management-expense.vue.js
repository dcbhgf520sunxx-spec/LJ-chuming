import { ref as x } from "vue";
import { reactive as E } from "vue";
import { resolveDirective as R } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as U } from "vue";
import { createVNode as t } from "vue";
import { withCtx as n } from "vue";
import { unref as g } from "vue";
import { createBlock as z } from "vue";
import { createTextVNode as $ } from "vue";
import { createCommentVNode as q } from "vue";
import { createElementVNode as y } from "vue";
import { toDisplayString as M } from "vue";
import { withDirectives as T } from "vue";
import { Fragment as I } from "vue";
import { ElMessage as v } from "element-plus";
import { ElCol as G } from "element-plus";
import { ElRow as H } from "element-plus";
import { ElButton as O } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { ElSwitch as K } from "element-plus";
import { ElPopconfirm as Q } from "element-plus";
import { ElTable as W } from "element-plus";
import { ElPagination as X } from "element-plus";
import { ElCard as Y } from "element-plus";
import Z from "./management-expense-dialog.vue.js";
import { a as ee, b as te, c as ae } from "../../../../../modules/management-config-46730d2f.js";
import { _ as ne, dp as oe, G as V, dq as le } from "../../../../../shared/runtime.js";
import { m as _ } from "../../../../../modules/contract-9b18cc88.js";
const se = { __name: "management-expense", setup(ie) {
  const w = x(""), f = [{ label: "自营", value: 1 }, { label: "合营", value: 2 }, { label: "内包制", value: 3 }], c = E({ pageNumber: 1, pageSize: 5 }), u = E({ tableList: [], total: 0 }), d = async (o) => {
    if (!V(_.get)) return w.value = "暂无权限";
    try {
      const { content: e, totalElements: s } = await ee({ ...c, ...o });
      e.forEach((i) => {
        i.projectAttribute && f.forEach((p, r) => {
          p.value === i.projectAttribute && (i.projectAttribute = f[r].label);
        });
      }), u.tableList = e, u.total = s;
    } catch (e) {
      console.log(e);
    }
  };
  d();
  const h = async () => {
    const o = le(c);
    await d(o);
  }, l = x(null), j = () => {
    l.value.Title = "创建项目管理费", l.value.dialogVisible = true, l.value.openType = "add";
  }, A = (o) => {
    l.value.Title = "编辑项目管理费", l.value.dialogVisible = true, l.value.tableList[0] = o, l.value.openType = "edit";
  }, S = async (o) => {
    await te([o.id]), v({ showClose: true, message: "删除成功", type: "success", duration: 1500 }), await d();
  }, k = async (o) => {
    const e = { ...o };
    typeof e.projectAttribute != "number" && f.forEach((s, i) => {
      s.label === e.projectAttribute && (e.projectAttribute = s.value);
    });
    try {
      await ae({ id: e.id, status: e.status }), v({ showClose: true, message: "修改状态成功", type: "success" });
    } catch {
      v({ showClose: true, message: "修改状态失败", type: "error" });
    }
  }, D = () => {
    l.value.dialogVisible = false, d();
  };
  return (o, e) => {
    const s = G, i = H, p = O, r = J, N = K, B = Q, L = W, P = X, F = Y, C = R("permission");
    return b(), U(I, null, [t(F, { "body-style": { padding: "20px" }, shadow: "always" }, { default: n(() => [t(i, { class: "header-row" }, { default: n(() => [t(s, null, { default: n(() => [t(oe, { headerTitle: "项目管理费" })]), _: 1 })]), _: 1 }), g(V)(g(_).add) ? (b(), z(i, { key: 0, class: "btn-row" }, { default: n(() => [t(s, { span: 3 }, { default: n(() => [t(p, { icon: "el-icon-plus", type: "primary", onClick: j }, { default: n(() => e[2] || (e[2] = [$("创建项目管理费")])), _: 1, __: [2] })]), _: 1 })]), _: 1 })) : q("", true), t(i, null, { default: n(() => [t(L, { data: u.tableList, "empty-text": w.value, border: "", "max-height": "800" }, { default: n(() => [t(r, { align: "center", label: "序号", "min-width": "60", type: "index" }), t(r, { align: "center", label: "项目类型", prop: "projectAttribute", width: "100" }), t(r, { align: "center", label: "合同额（元）", "min-width": "120", prop: "amountMax" }, { default: n((a) => [y("span", null, M(a.row.amountMin), 1), e[3] || (e[3] = y("span", null, " ~ ", -1)), y("span", null, M(a.row.amountMax), 1)]), _: 1 }), t(r, { align: "center", label: "管理费（%）", prop: "cashDeposit", width: "100" }), t(r, { align: "center", label: "状态", prop: "status", width: "100" }, { default: n((a) => [t(N, { modelValue: a.row.status, "onUpdate:modelValue": (m) => a.row.status = m, "active-value": 0, "inactive-value": 1, "active-color": "#139212", onChange: (m) => k(a.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 }), t(r, { align: "center", label: "操作", width: "140" }, { default: n((a) => [T(t(p, { icon: "el-icon-edit", size: "default", type: "primary", onClick: (m) => A(a.row) }, null, 8, ["onClick"]), [[C, g(_).edit]]), T((b(), z(B, { "hide-icon": "", title: "确定删除本条数据吗?", onConfirm: (m) => S(a.row) }, { reference: n(() => [t(p, { icon: "el-icon-delete", size: "default", type: "danger" })]), _: 2 }, 1032, ["onConfirm"])), [[C, g(_).del]])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text"])]), _: 1 }), t(P, { "current-page": c.pageNumber, "onUpdate:currentPage": e[0] || (e[0] = (a) => c.pageNumber = a), "page-size": c.pageSize, "onUpdate:pageSize": e[1] || (e[1] = (a) => c.pageSize = a), "page-sizes": [5, 10, 15, 20], total: u.total, layout: "total, sizes, prev, pager, next, jumper", style: { "margin-top": "10px" }, onSizeChange: h, onCurrentChange: h }, null, 8, ["current-page", "page-size", "total"])]), _: 1 }), t(Z, { ref_key: "dialogRef", ref: l, onClose: D }, null, 512)], 64);
  };
} }, me = ne(se, [["__scopeId", "data-v-a707d0fa"]]);
export {
  me as default
};
