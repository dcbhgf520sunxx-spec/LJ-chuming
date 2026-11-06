import { ref as u } from "vue";
import { computed as de } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as b } from "vue";
import { createBlock as C } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as c } from "vue";
import { normalizeStyle as F } from "vue";
import { unref as o } from "vue";
import { createVNode as d } from "vue";
import { withModifiers as k } from "vue";
import { createTextVNode as H } from "vue";
import { createCommentVNode as R } from "vue";
import { toDisplayString as $ } from "vue";
import { normalizeClass as re } from "vue";
import { isRef as ce } from "vue";
import { ElMessage as ue } from "element-plus";
import { nextTick as fe } from "vue";
import { ElInput as pe } from "element-plus";
import { ElFormItem as me } from "element-plus";
import { ElForm as he } from "element-plus";
import { ElTableColumn as ve } from "element-plus";
import { ElCard as ge } from "element-plus";
import { a as ye } from "../../../../modules/flow-config-2bf9a9d0.js";
import { _ as _e, u as xe, o as be, V as Ce, G as I, dY as j, aw as ke, i as we } from "../../../../shared/runtime.js";
const Te = { class: "left-wrap" }, Ve = { class: "right-wrap" }, Se = { class: "tree-org-node__text node-label" }, Ee = { __name: "form", props: { visible: { type: Boolean, default: false }, showType: { type: String }, treeInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible", "success", "delChange", "tree-change"], setup(y, { emit: K }) {
  const L = u(), N = u([]), m = u([]), h = u([]), O = K, q = u(), G = u([]), Y = u(false), w = y, { visible: T, handleClose: M } = xe({ emit: O, props: w, field: "visible", showHook: Z }), { maxHeight: V } = be({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"] }, T), J = u(false), z = u(), t = u({ id: void 0, list: [] }), Q = de(() => {
    const n = [];
    return t.value.list && P(t.value.list, n), n;
  }), W = { name: [{ required: true, message: "请输入流程名称", trigger: "blur" }] }, X = { notificationType: [{ required: true, message: "请输入流程名称", trigger: "blur" }] };
  async function Z() {
    var n, e;
    w.showType === "edit" ? (t.value = Ce(w.treeInfo), t.value.list = [t.value.sysPushFlowConfigLinkDTOS], await D(), m.value = (e = (n = h.value) == null ? void 0 : n.filter((l) => l.pid)) == null ? void 0 : e.map((l) => l.pid.toString()), console.log(m.value, "expandRowKeys.value")) : (t.value = { id: void 0, list: [] }, t.value.list = [{ idx: 1, id: Math.random(), pid: null, notificationType: void 0, hasChildren: false, children: [] }], N.value = []);
  }
  const { tableValidate: ee, wrongCellMask: le } = ke({ rules: X });
  async function ne() {
    if (!await z.value.validate()) return;
    h.value = B(t.value.list[0]);
    const { validResult: e } = ee(h.value);
    if (e) try {
      J.value = true;
      const l = { sysPushFlowConfigLinkSaveDTOParam: t.value.list[0], name: t.value.name, id: w.showType === "edit" ? t.value.id : void 0 };
      await ye(l), console.log(t.value.list, "_list"), ue.success("保存成功"), O("success"), M();
    } catch (l) {
      console.log(l);
    } finally {
    }
  }
  function te(n, e) {
    fe(() => {
      L.value.toggleRowExpansion(n, e);
    }), e ? m.value.push(n.id.toString()) : m.value = m.value.filter((l) => Number(l) !== n.id);
  }
  async function ie(n, e) {
    var S, E, _;
    const l = A(n.pid), i = (E = n.idx) == null ? void 0 : E.slice(0, (S = n.idx) == null ? void 0 : S.lastIndexOf(".")), r = l.children.findIndex((p) => p.id === n.id), g = { idx: i + `.${r + 2}`, id: Math.random(), pid: n.pid, notificationType: void 0, hasChildren: false, children: [] };
    if (l === null) t.value.list.push(g);
    else {
      l.children.splice(r + 1, 0, g);
      for (let p = r + 1; p < ((_ = l.children) == null ? void 0 : _.length); p++) l.children[p].idx = i + `.${p + 1}`;
    }
  }
  async function ae(n) {
    var l, i, r;
    n.children = n.children || [];
    const e = { idx: n.idx + "." + (((l = n.children) == null ? void 0 : l.length) + 1), id: "id" + Math.random(), pid: n.id, notificationType: void 0, hasChildren: false, children: [] };
    n.children.push(e), h.value = B(t.value.list[0]), m.value = (r = (i = h.value) == null ? void 0 : i.filter((f) => f.pid)) == null ? void 0 : r.map((f) => f.pid.toString());
  }
  function P(n, e) {
    n.forEach((l) => {
      e.push(l), l.children && l.children.length > 0 && P(l.children, e);
    });
  }
  function A(n) {
    return we(n) ? Q.value.find((e) => e.id === n) || {} : null;
  }
  function se(n) {
    var l, i;
    const e = A(n.pid);
    if (console.log(e, "del"), e) {
      const r = (l = e.children) == null ? void 0 : l.findIndex((f) => f.id === n.id);
      r !== -1 && ((i = e.children) == null || i.splice(r, 1), D(), e.children && e.children.length === 0 && (e.hasChildren = false));
    }
  }
  function B(n) {
    const e = [];
    function l(i) {
      e.push(i), i.children && i.children.forEach(l);
    }
    return l(n), e;
  }
  function D(n) {
    var e, l;
    h.value = B(t.value.list[0]), N.value = (l = (e = h.value) == null ? void 0 : e.filter((i) => i.notificationType)) == null ? void 0 : l.map((i) => i.notificationType);
  }
  return (n, e) => {
    const l = x("common-button"), i = pe, r = me, f = he, g = ve, S = x("common-select"), E = x("common-table"), _ = ge, p = x("vue3-tree-org"), oe = x("common-drawer");
    return b(), C(oe, { ref: "drawerRef", title: "", modelValue: o(T), "onUpdate:modelValue": e[1] || (e[1] = (a) => ce(T) ? T.value = a : null), direction: "rtl", withHeader: false, "close-on-click-modal": false, "before-close": o(M), size: "90%", "custom-class": "flow-config" }, { content: s(() => [c("div", { class: "wrap", style: F(`height: ${o(V) - 200}px`) }, [c("div", Te, [c("div", { style: F(`height: ${o(V) - 200}px`) }, [d(_, { class: "line-box box-card" }, { header: s(() => [e[4] || (e[4] = c("span", { style: { "line-height": "28px" } }, "流程配置", -1)), c("div", null, [o(I)(y.permission.save) ? (b(), C(l, { key: 0, type: "success", onClick: k(ne, ["stop"]) }, { default: s(() => e[2] || (e[2] = [H(" 保存 ")])), _: 1, __: [2] })) : R("", true), d(l, { onClick: k(o(M), ["stop"]) }, { default: s(() => e[3] || (e[3] = [H("关闭")])), _: 1, __: [3] }, 8, ["onClick"])])]), default: s(() => [d(f, { ref_key: "formRef", ref: z, model: t.value, rules: W, "label-width": "90px" }, { default: s(() => [d(r, { label: "流程名称", prop: "name", class: "first-select" }, { default: s(() => [d(i, { modelValue: t.value.name, "onUpdate:modelValue": e[0] || (e[0] = (a) => t.value.name = a), modelModifiers: { trim: true }, clearable: "", placeholder: "流程名称", size: "default", class: "input-underline", maxlength: "20", style: { width: "360px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"]), d(E, { ref_key: "tableRef", ref: L, data: t.value.list, "show-empty-symbol": false, "empty-text": "暂无数据", returnSourceData: "", "tree-props": { children: "children", hasChildren: "hasChildren" }, "expand-row-keys": m.value, "row-key": "id", style: { width: "100%" }, stripe: false, "max-height": o(V) - 90, "cell-class-name": o(le), onExpandChange: te }, { default: s(() => [d(g, { type: "idx", align: "center", width: "80" }, { default: s(({ row: a }) => [c("span", null, $(a.idx), 1)]), _: 1 }), d(g, { key: "notificationType", prop: "notificationType", label: "流程名称", align: "center", "min-width": "200" }, { default: s(({ row: a }) => [d(S, { modelValue: a.notificationType, "onUpdate:modelValue": (v) => a.notificationType = v, options: o(j).ENUM, filterable: "", clearable: "", class: re(["input-underline filter-item", { error: a.isError }]), type: "enum", placeholder: "业务节点", disabledVal: [...N.value], style: { width: "230px" }, onChange: D }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabledVal", "class"])]), _: 1 }), d(g, { label: "操作", width: "180px", align: "center", fixed: "right" }, { default: s(({ row: a, $index: v }) => [v !== 0 && o(I)(y.permission.addSiblingNode) ? (b(), C(l, { key: 0, type: "warning", icon: "el-icon-plus", onClick: k((U) => ie(a, v), ["stop"]) }, null, 8, ["onClick"])) : R("", true), o(I)(y.permission.addSonNode) ? (b(), C(l, { key: 1, type: "success", icon: "el-icon-plus", onClick: k((U) => ae(a, v), ["stop"]) }, null, 8, ["onClick"])) : R("", true), v !== 0 && o(I)(y.permission.delNode) ? (b(), C(l, { key: 2, type: "danger", icon: "el-icon-delete", onClick: k((U) => se(a, v), ["stop"]) }, null, 8, ["onClick"])) : R("", true)]), _: 1 })]), _: 1 }, 8, ["data", "expand-row-keys", "max-height", "cell-class-name"])]), _: 1 })], 4)]), c("div", Ve, [d(_, { class: "line-box box-card" }, { header: s(() => e[5] || (e[5] = [c("span", { style: { "line-height": "28px" } }, "流程预览", -1)])), default: s(() => [c("div", { style: F(`height: ${o(V) - 40}px`) }, [d(p, { data: t.value.list[0], center: "", ref_key: "treeOrgRef", ref: q, props: { label: "notificationType", children: "children", expand: "expand" }, horizontal: false, collapsable: false, "define-menus": [{ name: "复制文本", command: "copy" }], "clone-node-drag": Y.value, "selected-key": G.value }, { default: s(({ node: a }) => [c("div", Se, [c("div", null, $(o(j).VL[a.label]), 1)])]), _: 1 }, 8, ["data", "clone-node-drag", "selected-key"])], 4)]), _: 1 })])], 4)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Me = _e(Ee, [["__scopeId", "data-v-1ecff04b"]]);
export {
  Me as default
};
