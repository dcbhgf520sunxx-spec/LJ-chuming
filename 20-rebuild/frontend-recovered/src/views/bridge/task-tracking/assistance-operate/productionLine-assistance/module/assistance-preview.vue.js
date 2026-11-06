import { ref as C } from "vue";
import { inject as B } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as s } from "vue";
import { createBlock as n } from "vue";
import { withCtx as o } from "vue";
import { unref as e } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as l } from "vue";
import { createCommentVNode as c } from "vue";
import { createVNode as d } from "vue";
import { createElementVNode as N } from "vue";
import { isRef as L } from "vue";
import { ElNotification as j } from "element-plus";
import { ElTag as D } from "element-plus";
import { ElTableColumn as Q } from "element-plus";
import { s as z, b as F } from "../../../../../../modules/productionLine-assistance-4576379e.js";
import { u as O, o as S, ce as r } from "../../../../../../shared/runtime.js";
const K = { __name: "assistance-preview", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} }, list: { type: Array, default: () => [] } }, emits: ["update:visible", "success"], setup(f, { emit: V }) {
  const k = V, T = f, { visible: w, handleClose: v } = O({ emit: k, props: T, field: "visible" }), { maxHeight: H } = S({ mainBox: ".assistance-preview", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, w), I = C([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]]]), i = B("crud"), g = C(false);
  async function R() {
    try {
      g.value = true;
      const y = T.list.map((u) => ({ id: u.id, quantity: u.editQuantity, groupsId: u.groupsId }));
      i.query.taskTypeEnum === r.MACHINE_PART.V ? await z(y) : await F(y), j({ title: "产线协同保存成功", type: "success", duration: 2500 }), v(), k("success");
    } catch (y) {
      console.log("保存产线协同报错", y);
    } finally {
      g.value = false;
    }
  }
  return (y, u) => {
    const E = D, q = h("common-button"), a = Q, M = h("common-table"), P = h("common-dialog");
    return s(), n(P, { "custom-class": "assistance-preview", "append-to-body": "", "close-on-click-modal": false, title: "产线协同预览", modelValue: e(w), "onUpdate:modelValue": u[0] || (u[0] = (t) => L(w) ? w.value = t : null), width: "1100px", "before-close": e(v) }, { titleAfter: o(() => [e(i).query.taskTypeEnum !== e(r).MACHINE_PART.V ? (s(), n(E, { key: 0, effect: "plain" }, { default: o(() => {
      var t, p, m;
      return [_(" 原生产组：" + l((t = f.info.workshop) == null ? void 0 : t.name) + ">" + l((p = f.info.productionLine) == null ? void 0 : p.name) + ">" + l((m = f.info.groups) == null ? void 0 : m.name), 1)];
    }), _: 1 })) : c("", true)]), titleRight: o(() => [d(q, { onClick: R, loading: g.value, size: "default", type: "primary" }, { default: o(() => u[1] || (u[1] = [_("保存")])), _: 1, __: [1] }, 8, ["loading"])]), default: o(() => [d(M, { data: f.list, "data-format": I.value, "max-height": e(H), style: { width: "100%" } }, { default: o(() => [d(a, { label: "序号", type: "index", align: "center", width: "60" }), e(i).query.taskTypeEnum !== e(r).MACHINE_PART.V ? (s(), n(a, { key: 0, prop: "area.name", "show-overflow-tooltip": true, label: "区域", "min-width": "100px", align: "center" })) : c("", true), e(i).query.taskTypeEnum === e(r).CELL.V ? (s(), n(a, { key: 1, prop: "attributeType", "show-overflow-tooltip": true, label: "属性", width: "90", align: "center" }, { default: o(({ row: t }) => [d(E, { type: t.attributeType === "单元件" ? "warning" : "success" }, { default: o(() => [_(l(t.attributeType), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : c("", true), e(i).query.taskTypeEnum === e(r).MACHINE_PART.V ? (s(), n(a, { key: 2, prop: "cutNumber", "show-overflow-tooltip": true, label: "切割指令号", "min-width": "100px", align: "center" })) : c("", true), e(i).query.taskTypeEnum !== e(r).MACHINE_PART.V ? (s(), n(a, { key: 3, prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100px", align: "center" })) : c("", true), d(a, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "100px", align: "center" }), e(i).query.taskTypeEnum !== e(r).MACHINE_PART.V ? (s(), n(a, { key: 4, prop: "length", "show-overflow-tooltip": true, label: "长度(mm)", width: "100px", align: "center" })) : c("", true), d(a, { prop: "editQuantity", "show-overflow-tooltip": true, label: "协同数量", width: "80", align: "center" }), e(i).query.taskTypeEnum === e(r).MACHINE_PART.V ? (s(), n(a, { key: 5, align: "center", prop: "askCompleteTime", "show-overflow-tooltip": true, label: "计划完成日期", width: "120px" })) : c("", true), e(i).query.taskTypeEnum === e(r).MACHINE_PART.V ? (s(), n(a, { key: 6, prop: "group.name", "show-overflow-tooltip": true, label: "原生产组", "min-width": "160px" }, { default: o(({ row: t }) => {
      var p, m, b;
      return [N("span", null, l((p = t.workshop) == null ? void 0 : p.name) + ">" + l((m = t.productionLine) == null ? void 0 : m.name) + ">" + l((b = t.groups) == null ? void 0 : b.name), 1)];
    }), _: 1 })) : c("", true), d(a, { prop: "groupsName", "show-overflow-tooltip": true, label: "协同产组", "min-width": "150" }, { default: o(({ row: t }) => {
      var p, m, b, x, A;
      return [N("span", null, l((m = (p = t.assistance) == null ? void 0 : p.workshop) == null ? void 0 : m.name) + ">" + l((x = (b = t.assistance) == null ? void 0 : b.productionLine) == null ? void 0 : x.name) + ">" + l((A = t.assistance) == null ? void 0 : A.groupsName), 1)];
    }), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  K as default
};
