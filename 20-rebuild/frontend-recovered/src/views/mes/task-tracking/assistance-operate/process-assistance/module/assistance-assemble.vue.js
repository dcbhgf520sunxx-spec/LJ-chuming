import { ref as S } from "vue";
import { watch as D } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as g } from "vue";
import { createBlock as v } from "vue";
import { withCtx as p } from "vue";
import { createVNode as u } from "vue";
import { createElementVNode as _ } from "vue";
import { toDisplayString as h } from "vue";
import { unref as w } from "vue";
import { createCommentVNode as L } from "vue";
import { createElementBlock as V } from "vue";
import { withModifiers as W } from "vue";
import { createTextVNode as G } from "vue";
import { nextTick as z } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElCascader as K } from "element-plus";
import { ElTable as $ } from "element-plus";
import { _ as J, V as X, rL as R } from "../../../../../../shared/runtime.js";
const Y = { key: 1 }, Z = { key: 1 }, ee = { key: 1, class: "tip" }, te = { __name: "assistance-assemble", props: { tableData: { type: Array, default: () => [] }, info: { type: Object, default: () => {
} }, classIdGroupsObj: { type: Object, default: () => {
} }, maxHeight: { type: Number }, wrongCellMask: { type: Function } }, emits: ["deal", "select"], setup(M, { emit: P }) {
  const y = M, A = P, m = S(y.tableData), C = S([]), k = S(void 0), b = S([]), E = (t) => {
    var l, d, i, r;
    return ((r = (i = (d = (l = m.value) == null ? void 0 : l[0]) == null ? void 0 : d.children) == null ? void 0 : i[0]) == null ? void 0 : r.id) === t.id;
  };
  D(() => y.tableData, () => {
    m.value = X(y.tableData), N(m.value), C.value = [], b.value = [];
  }, { deep: true, immediate: true }), D(() => C.value, () => {
    A("select", C.value);
  }, { deep: true });
  function N(t, a) {
    t && t.length && t.forEach((l) => {
      l.isSelect = false, a && (l.parentId = a), l.children && l.children.length && N(l.children, l.uid);
    });
  }
  function U(t) {
    C.value = t.filter((a) => !a.isParent);
  }
  function q(t, a) {
    O(a);
  }
  function O(t) {
    t.isSelect === "" && k.value.toggleRowSelection(t, true), t.isSelect = !t.isSelect;
    const a = l(t);
    a === 1 ? (d(t.children), b.value.push(t.uid)) : a === 2 ? (d(t.children), i(t), b.value.push(t.uid, t.parentId)) : a === 3 && (i(t), b.value.push(t.parentId));
    function l(o) {
      return o.parentId === void 0 ? 1 : o.parentId && !(o.children && o.children.length) ? 3 : 2;
    }
    function d(o) {
      o && o.length && o.forEach((s) => {
        s.isSelect = t.isSelect, x(s, t.isSelect), s.children && s.children.length && d(s.children);
      });
    }
    function i(o) {
      const s = I(m.value, o.parentId), e = r([], s.children), n = e.every((f) => f === true), c = e.every((f) => f === false);
      n ? (s.isSelect = true, x(s, true)) : c ? (s.isSelect = false, x(s, false)) : s.isSelect = "", s.parentId !== void 0 && i(s);
    }
    function r(o, s) {
      return !s || !s.length || s.forEach((e) => {
        o.push(e.isSelect), e.children && e.children.length && r(o, e.children);
      }), o;
    }
    function I(o, s) {
      let e = null;
      function n(c) {
        for (let f = 0; f < c.length; f++) {
          if (c[f].uid === s) {
            e = c[f];
            break;
          }
          c[f].children && c[f].children.length && n(c[f].children);
        }
      }
      return n(o), e;
    }
  }
  function x(t, a) {
    t && z(() => {
      k.value && k.value.toggleRowSelection(t, a);
    });
  }
  function Q(t) {
    const d = m.value.filter((i) => {
      var r;
      return (r = i.totalCanAssistMete) == null ? void 0 : r.quantity;
    }).map((i) => i.isSelect).every((i) => i);
    m.value.forEach((i) => {
      var r;
      (r = i.totalCanAssistMete) != null && r.quantity && (i.isSelect = d, x(i, !d), q(t, i));
    });
  }
  function j({ row: t, column: a }) {
    let l = "";
    return l = y.wrongCellMask({ row: t, column: a }), t.isSelect === "" && (l = "indeterminate " + l), l;
  }
  function B(t, a, l) {
    b.value.includes(a.parentId) || b.value.push(a.parentId), !E(a) && !t && (a.groupsId = "同上");
  }
  function F(t) {
    var a;
    return (a = t.totalCanAssistMete) == null ? void 0 : a.quantity;
  }
  return (t, a) => {
    var s;
    const l = H, d = T("table-cell-tag"), i = T("common-input-number"), r = K, I = T("common-button"), o = $;
    return ((s = m.value) == null ? void 0 : s.length) > 0 ? (g(), v(o, { key: 0, data: m.value, ref_key: "multipleTable", ref: k, border: "", "row-key": "uid", "tree-props": { children: "children" }, "cell-class-name": j, "expand-row-keys": b.value, "default-expand-all": false, size: "default", "max-height": M.maxHeight, style: { width: "100%" }, onSelect: q, onSelectAll: Q, onSelectionChange: U, "header-cell-style": { background: "#fafafa" } }, { default: p(() => [u(l, { type: "selection", "reserve-selection": true, width: "55", align: "center", selectable: F }), u(l, { label: "序号", type: "index", align: "center", width: "60" }, { default: p(({ row: e }) => [_("span", null, h(e.idx), 1)]), _: 1 }), u(l, { prop: "areaName", "show-overflow-tooltip": true, label: "区域", "min-width": "100px", align: "center" }, { default: p(({ row: e }) => [e.isParent ? (g(), v(d, { key: 0, name: w(R).V[e.taskTypeEnum].SL, color: w(R).V[e.taskTypeEnum].COLOR, offset: 10 }, null, 8, ["name", "color"])) : L("", true), _("span", null, h(e.areaName), 1)]), _: 1 }), u(l, { prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100px", align: "center" }), u(l, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "100px", align: "center" }), u(l, { prop: "length", "show-overflow-tooltip": true, label: "长度(mm)", width: "100px", align: "center" }), u(l, { align: "center", prop: "totalTaskMete.quantity", "show-overflow-tooltip": true, label: "任务数（件）" }, { default: p(({ row: e }) => {
      var n;
      return [_("span", null, h(((n = e.totalTaskMete) == null ? void 0 : n.quantity) || 0), 1)];
    }), _: 1 }), u(l, { align: "center", prop: "totalTaskMete.netWeight", "show-overflow-tooltip": true, label: "任务总净重（kg）" }, { default: p(({ row: e }) => {
      var n;
      return [_("span", null, h(((n = e.totalTaskMete) == null ? void 0 : n.netWeight) || 0), 1)];
    }), _: 1 }), u(l, { align: "center", prop: "totalCompleteMete.quantity", "show-overflow-tooltip": true, label: "完成数（件）" }, { default: p(({ row: e }) => {
      var n;
      return [_("span", null, h(((n = e.totalCompleteMete) == null ? void 0 : n.quantity) || 0), 1)];
    }), _: 1 }), u(l, { align: "center", prop: "totalCompleteMete.netWeight", "show-overflow-tooltip": true, label: "完成总净重（kg）" }, { default: p(({ row: e }) => {
      var n;
      return [_("span", null, h(((n = e.totalCompleteMete) == null ? void 0 : n.netWeight) || 0), 1)];
    }), _: 1 }), u(l, { align: "center", prop: "totalAssistQuantity", "show-overflow-tooltip": true, label: "已协同数量" }, { default: p(({ row: e }) => [_("span", null, h(e.totalAssistQuantity || 0), 1)]), _: 1 }), u(l, { align: "center", prop: "totalCanAssistMete.quantity", "show-overflow-tooltip": true, label: "可协同数量" }, { default: p(({ row: e }) => {
      var n;
      return [_("span", null, h((n = e.totalCanAssistMete) == null ? void 0 : n.quantity), 1)];
    }), _: 1 }), u(l, { align: "center", prop: "assistQuantity", "show-overflow-tooltip": true, label: "[批量办理]协同数量", width: "140px" }, { default: p(({ row: e }) => {
      var n;
      return [e != null && e.isParent ? (g(), V("span", Y, h(e.assistQuantity), 1)) : (g(), v(i, { key: 0, modelValue: e.assistQuantity, "onUpdate:modelValue": (c) => e.assistQuantity = c, step: 1, controls: false, min: 0, max: (n = e.totalCanAssistMete) == null ? void 0 : n.quantity, placeholder: "协同数量", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max"]))];
    }), _: 1 }), u(l, { "show-overflow-tooltip": true, prop: "groupsId", label: "协同班组", "min-width": "150px", align: "center" }, { default: p(({ row: e }) => {
      var n;
      return [e != null && e.isParent ? (g(), V("span", Z, h("-"))) : (g(), v(r, { key: 0, modelValue: e.groupsId, "onUpdate:modelValue": (c) => e.groupsId = c, options: (n = M.classIdGroupsObj[e.configId]) == null ? void 0 : n.list, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": "", disabled: e.isComplete, filterable: "", clearable: "", placeholder: E(e) ? "请选择生产组" : "同上", style: { width: "100%" }, onChange: (c) => B(c, e, e.index) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled", "placeholder", "onChange"]))];
    }), _: 1 }), u(l, { align: "center", "show-overflow-tooltip": true, label: "操作" }, { default: p(({ row: e }) => [e.isParent ? L("", true) : (g(), v(I, { key: 0, size: "default", type: "success", onClick: W((n) => A("deal", e), ["stop"]) }, { default: p(() => a[0] || (a[0] = [G("办理")])), _: 2, __: [0] }, 1032, ["onClick"]))]), _: 1 })]), _: 1 }, 8, ["data", "expand-row-keys", "max-height"])) : (g(), V("div", ee, "* 暂无数据"));
  };
} }, ne = J(te, [["__scopeId", "data-v-33084ab9"]]);
export {
  ne as default
};
