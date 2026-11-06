import { ref as c } from "vue";
import { watch as ke } from "vue";
import { resolveComponent as L } from "vue";
import { resolveDirective as je } from "vue";
import { openBlock as r } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as a } from "vue";
import { withDirectives as K } from "vue";
import { withModifiers as S } from "vue";
import { createTextVNode as h } from "vue";
import { unref as s } from "vue";
import { createVNode as l } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as x } from "vue";
import { createElementBlock as b } from "vue";
import { Fragment as k } from "vue";
import { renderList as q } from "vue";
import { createCommentVNode as H } from "vue";
import { normalizeStyle as W } from "vue";
import { isRef as Re } from "vue";
import { ElMessageBox as Se } from "element-plus";
import { ElBadge as Ce } from "element-plus";
import { ElDescriptionsItem as Ie } from "element-plus";
import { ElTooltip as Ee } from "element-plus";
import { ElDescriptions as Be } from "element-plus";
import { ElInput as Ne } from "element-plus";
import { ElTableColumn as ze } from "element-plus";
import { ElTag as Le } from "element-plus";
import { ElForm as Te } from "element-plus";
import { vLoading as Fe } from "element-plus";
import { g as Ue } from "../../../../../../modules/process-611d795f.js";
import { _ as De, mx as Pe, u as $e, tu as X, o as Oe, i as T, z as M, ts as qe, tt as He, bb as Me, q as Ye, tv as Y, iy as Ae } from "../../../../../../shared/runtime.js";
import { u as Je } from "../../../../../../modules/plan-d12d7ccf.js";
import Qe from "./artifact-bind-detail.vue.js";
import Ge from "./structure-type.vue.js";
import Ke from "./artifact-bind-current.vue.js";
const We = { class: "project-div" }, Xe = { style: { width: "30%" } }, Ze = { style: { width: "30%" } }, et = { style: { "word-break": "break-all" } }, tt = { class: "head-container", style: { "margin-bottom": "0" } }, lt = { style: { display: "flex" } }, ot = { style: { display: "flex", "margin-bottom": "10px" } }, at = { style: { flex: "1", "padding-right": "5px" } }, nt = { style: { flex: "1", "text-align": "right", "padding-left": "5px" } }, st = { style: { "margin-bottom": "10px" } }, it = { style: { "margin-bottom": "10px" } }, rt = { style: { "margin-bottom": "10px" } }, ut = { style: { "margin-bottom": "10px" } }, dt = { style: { "text-align": "right" } }, ct = ["onClick"], mt = { __name: "artifact-bind-form", props: { modelValue: { type: Boolean, require: true }, currentRow: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(u, { emit: Z }) {
  const { projects: ee } = Pe(), j = u, te = c(JSON.parse(JSON.stringify({ fileName: void 0 }))), d = c({}), p = c({}), le = c(), F = c(false), R = c([]), oe = c(), w = c(), U = c(false), D = c(false), I = c(false), A = c(), f = c([]), C = c([]), ae = { fileName: { required: true, message: "请输入文件命名", trigger: "blur" } }, P = Z, { visible: E, handleClose: $ } = $e({ emit: P, props: j });
  ke(() => E.value, (t) => {
    var e;
    t && (d.value = {}, d.value.processType = j.currentRow.processType, d.value.boolBindStatus = X.NO.V, d.value.projectId = j.currentRow.boolSingleProject ? (e = j.currentRow.project) == null ? void 0 : e.id : ee.value[0].id, V(), f.value = []);
  }, { deep: true, immediate: true });
  const J = c(), { maxHeight: B } = Oe({ mainBox: ".bind-form", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, J);
  function ne() {
    var t;
    (t = f.value) != null && t.length ? Se.confirm("您本次操作的绑定记录尚未提交，确认退出？", "提示", { type: "warning" }).then(() => {
      $();
    }).catch(() => {
    }) : $();
  }
  function se() {
    P("success"), $();
  }
  const ie = c([["project", "parse-project"]]);
  function re(t) {
    var e;
    return ((e = t.sourceRow) == null ? void 0 : e.bindStatus) !== Y.YES.V;
  }
  function Q(t) {
    A.value = t.attachmentId, I.value = true;
  }
  async function V() {
    let t = [];
    if (!d.value.projectId || !j.currentRow.id || !p.value.structureClassIds) {
      R.value = t;
      return;
    }
    F.value = true;
    try {
      const { content: e = [] } = await Ue({ processFileId: j.currentRow.id, ...d.value, ...p.value });
      e.map((n, g) => {
        var m, N;
        n.uuid = ((m = n.project) == null ? void 0 : m.id) + "_" + n.serialNumber, n.projectId = (N = n.project) == null ? void 0 : N.id;
      }), t = e;
    } catch (e) {
      console.log("构件明细", e);
    } finally {
      R.value = t, F.value = false;
    }
  }
  function ue(t) {
    const e = t.map((n) => n.structureClassId) || [];
    p.value.structureClassIds = e.join(","), V();
  }
  function de() {
    p.value = {}, V();
  }
  function ce() {
    R.value.forEach((t) => {
      var e;
      t.bindStatus !== Y.YES.V && ((e = w == null ? void 0 : w.value) == null || e.toggleRowSelection(t, true));
    }), C.value.forEach((t) => {
      f.value.findIndex((e) => e.uuid === t.uuid) < 0 && f.value.push(t);
    });
  }
  function me() {
    C.value.forEach((t) => {
      f.value.findIndex((e) => e.uuid === t.uuid) < 0 && f.value.push(t);
    });
  }
  function fe(t) {
    var n;
    const e = R.value.find((g) => g.uuid === t.uuid);
    (n = w == null ? void 0 : w.value) == null || n.toggleRowSelection(e, true), C.value.forEach((g) => {
      f.value.findIndex((m) => m.uuid === g.uuid) < 0 && f.value.push(g);
    });
  }
  function pe(t) {
    C.value = t;
  }
  function ve(t) {
    var g;
    const e = R.value.find((m) => m.uuid === t.uuid), n = f.value.findIndex((m) => m.uuid === t.uuid);
    T(n) && f.value.splice(n, 1), e && ((g = w == null ? void 0 : w.value) == null || g.toggleRowSelection(e, false));
  }
  function be() {
    var t;
    (t = f.value) != null && t.length && (U.value = true);
  }
  return (t, e) => {
    const n = L("common-button"), g = Ce, m = Ie, N = Ee, G = Be, we = L("common-radio-button"), z = Ne, y = ze, ge = Le, ye = L("common-table"), he = Te, _e = L("common-drawer"), xe = je("permission"), Ve = Fe;
    return r(), _(_e, { "append-to-body": "", ref_key: "drawerRef", ref: J, modelValue: s(E), "onUpdate:modelValue": e[13] || (e[13] = (v) => Re(E) ? E.value = v : null), top: "10vh", width: "600px", "before-close": ne, title: "绑定构件", "wrapper-closable": false, size: "95%", "custom-class": "bind-form" }, { titleRight: a(() => [K((r(), _(n, { size: "default", type: "success", onClick: e[0] || (e[0] = S((v) => D.value = true, ["stop"])) }, { default: a(() => e[14] || (e[14] = [h("查看已绑定构件")])), _: 1, __: [14] })), [[xe, s(Je).detail]]), l(g, { value: f.value.length, max: 99, style: { "margin-right": "10px" } }, { default: a(() => [l(n, { size: "default", type: "primary", onClick: S(be, ["stop"]) }, { default: a(() => e[15] || (e[15] = [h("本次绑定构件预览提交")])), _: 1, __: [15] })]), _: 1 }, 8, ["value"])]), content: a(() => [l(he, { ref_key: "formRef", ref: le, model: te.value, rules: ae, size: "default", "label-width": "100px" }, { default: a(() => {
      var v;
      return [l(G, { class: "margin-top", column: 3, border: "", "label-width": "110" }, { default: a(() => [l(m, { "label-class-name": "desc-label", label: "文件名称", span: u.currentRow.boolSingleProject ? 2 : 3 }, { default: a(() => [i("div", null, [i("span", { style: { cursor: "pointer", color: "#409eff", "word-break": "break-all" }, onClick: e[1] || (e[1] = S((o) => Q(u.currentRow), ["stop"])) }, x(u.currentRow.fileName), 1)])]), _: 1 }, 8, ["span"]), u.currentRow.boolSingleProject ? (r(), _(m, { key: 0, "label-class-name": "desc-label", label: "所属项目", span: 1 }, { default: a(() => [l(N, { placement: "top" }, { content: a(() => [s(T)(u.currentRow.projectList) ? (r(true), b(k, { key: 0 }, q(u.currentRow.projectList, (o) => (r(), b("div", { key: o.id }, x(s(M)(o)), 1))), 128)) : (r(), b(k, { key: 1 }, [h("-")], 64))]), default: a(() => [i("div", We, [s(T)(u.currentRow.projectList) ? (r(), b(k, { key: 0 }, [u.currentRow.projectList.length === 1 ? (r(true), b(k, { key: 0 }, q(u.currentRow.projectList, (o) => (r(), b("span", { key: o.id }, x(s(M)(o)), 1))), 128)) : (r(true), b(k, { key: 1 }, q(u.currentRow.projectList, (o) => (r(), b("span", { key: o.id }, "【" + x(s(M)(o)) + "】", 1))), 128))], 64)) : (r(), b(k, { key: 1 }, [h("-")], 64))])]), _: 1 })]), _: 1 })) : H("", true), l(m, { "label-class-name": "desc-label", "class-name": "content-class", class: "", label: "文件类型" }, { default: a(() => [i("div", Xe, x(s(qe).VL[u.currentRow.processType]), 1)]), _: 1 }), l(m, { "label-class-name": "desc-label", "class-name": "content-class", label: "文件属性" }, { default: a(() => [i("div", Ze, x(s(He).VL[u.currentRow.boolSingleProject]), 1)]), _: 1 }), l(m, { "label-class-name": "desc-label", "class-name": "content-class", label: "备注" }, { default: a(() => [i("div", et, x(u.currentRow.remark), 1)]), _: 1 })]), _: 1 }), l(G, { class: "margin-top", column: 1, border: "", style: { margin: "15px 0" } }, { default: a(() => [l(m, { "label-class-name": "desc-label", label: "查询范围", "label-width": "110" }, { default: a(() => [i("div", tt, [l(we, { modelValue: d.value.boolBindStatus, "onUpdate:modelValue": e[2] || (e[2] = (o) => d.value.boolBindStatus = o), options: s(X).ENUM, "show-option-all": "", class: "filter-item", style: { "margin-bottom": "0" }, type: "enum", onChange: V }, null, 8, ["modelValue", "options"]), l(Me, { clearable: false, ref_key: "projectRef", ref: oe, modelValue: d.value.projectId, "onUpdate:modelValue": e[3] || (e[3] = (o) => d.value.projectId = o), disabled: u.currentRow.boolSingleProject, class: "filter-item", style: { width: "350px", "margin-bottom": "0" }, placeholder: "项目搜索", onChange: V }, null, 8, ["modelValue", "disabled"]), l(s(Ye), { ref: "monomerSelectRef", modelValue: d.value.monomerId, "onUpdate:modelValue": e[4] || (e[4] = (o) => d.value.monomerId = o), style: { width: "270px", "margin-bottom": "0" }, default: false, "project-id": d.value.projectId, clearable: "", class: "filter-item", onChange: V }, null, 8, ["modelValue", "project-id"])])]), _: 1 })]), _: 1 }), i("div", lt, [l(s(Ge), { query: d.value, onChange: ue, maxHeight: s(B) - 240 }, null, 8, ["query", "maxHeight"]), i("div", { style: W(`padding:10px 15px;background:#f5f5f5;min-height:${s(B) - 240}px;`) }, [i("div", ot, [i("div", at, [l(n, { class: "filter-item", size: "default", type: "warning", onClick: S(ce, ["stop"]), style: { width: "100%" } }, { default: a(() => e[16] || (e[16] = [h("加入所有")])), _: 1, __: [16] })]), i("div", nt, [l(n, { class: "filter-item", size: "default", type: "primary", style: { width: "100%" }, onClick: me, disabled: !((v = C.value) != null && v.length) }, { default: a(() => e[17] || (e[17] = [h(" 加入所选 ")])), _: 1, __: [17] }, 8, ["disabled"])])]), i("div", st, [l(z, { modelValue: p.value.name, "onUpdate:modelValue": e[5] || (e[5] = (o) => p.value.name = o), placeholder: "构件名称搜索", class: "filter-item", style: { width: "270px" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), i("div", it, [l(z, { modelValue: p.value.serialNumber, "onUpdate:modelValue": e[6] || (e[6] = (o) => p.value.serialNumber = o), placeholder: "构件编号", class: "filter-item", style: { width: "270px" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), i("div", rt, [l(z, { modelValue: p.value.specification, "onUpdate:modelValue": e[7] || (e[7] = (o) => p.value.specification = o), placeholder: "构件规格", class: "filter-item", style: { width: "270px" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), i("div", ut, [l(z, { modelValue: p.value.material, "onUpdate:modelValue": e[8] || (e[8] = (o) => p.value.material = o), placeholder: "构件材质", class: "filter-item", style: { width: "270px" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), i("div", dt, [l(n, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: S(V, ["stop"]) }, { default: a(() => e[18] || (e[18] = [h("搜索")])), _: 1, __: [18] }), l(n, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh", onClick: S(de, ["stop"]) }, { default: a(() => e[19] || (e[19] = [h(" 重置 ")])), _: 1, __: [19] })]), e[20] || (e[20] = i("div", { style: { color: "#e6a23c", "font-size": "13px", "margin-top": "5px" } }, "* 注意：", -1)), e[21] || (e[21] = i("div", { style: { color: "#e6a23c", "font-size": "13px" } }, "1. 专用文件：只可绑定文件指定项目的构件", -1))], 4), i("div", { style: W(`flex:1;padding:10px;padding-left:0;background:#f5f5f5;min-height:${s(B) - 240}px`) }, [K((r(), _(ye, { ref_key: "detailRef", ref: w, border: "", data: R.value, "max-height": s(B) - 240, style: { width: "100%" }, class: "table-form", "data-format": ie.value, onSelectionChange: pe }, { default: a(() => [l(y, { type: "selection", width: "55", align: "center", selectable: re }), l(y, { label: "序号", type: "index", align: "center", width: "55" }), u.currentRow.boolSingleProject ? H("", true) : (r(), _(y, { key: 0, prop: "project", label: "项目", align: "left", "min-width": "150", "show-overflow-tooltip": "" })), l(y, { prop: "monomerName", label: "单体", align: "left", "show-overflow-tooltip": "" }), l(y, { prop: "serialNumber", label: "编号", align: "left", "show-overflow-tooltip": "" }), l(y, { prop: "name", label: "构件名称", align: "center", "show-overflow-tooltip": "" }), l(y, { prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "" }), l(y, { prop: "material", label: "材质", align: "center", "show-overflow-tooltip": "", width: "80" }), l(y, { prop: "processFileDTO", label: "绑定文件名称", align: "left", "show-overflow-tooltip": "" }, { default: a((o) => [s(T)(o.row.processFileDTO) ? (r(), b("span", { key: 0, style: { cursor: "pointer", color: "#409eff" }, onClick: (O) => Q(o.row.processFileDTO) }, x(o.row.processFileDTO.fileName), 9, ct)) : (r(), b(k, { key: 1 }, [h("-")], 64))]), _: 1 }), l(y, { label: "操作", align: "center", width: "80" }, { default: a((o) => {
        var O;
        return [((O = o.row.sourceRow) == null ? void 0 : O.bindStatus) !== s(Y).YES.V ? (r(), _(n, { key: 0, size: "default", icon: "el-icon-plus", type: "primary", onClick: (pt) => fe(o.row) }, null, 8, ["onClick"])) : (r(), _(ge, { key: 1, type: "success" }, { default: a(() => e[22] || (e[22] = [h("已绑定")])), _: 1, __: [22] }))];
      }), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[Ve, F.value]])], 4)])];
    }), _: 1 }, 8, ["model"]), l(s(Ke), { modelValue: U.value, "onUpdate:modelValue": e[9] || (e[9] = (v) => U.value = v), currentRow: u.currentRow, showList: f.value, onDelete: ve, onSuccess: se, projectId: d.value.projectId, monomerId: d.value.monomerId }, null, 8, ["modelValue", "currentRow", "showList", "projectId", "monomerId"]), l(s(Qe), { modelValue: D.value, "onUpdate:modelValue": e[10] || (e[10] = (v) => D.value = v), currentRow: u.currentRow, onSuccess: e[11] || (e[11] = (v) => P("success")) }, null, 8, ["modelValue", "currentRow"]), I.value ? (r(), _(Ae, { key: 0, isVisible: I.value, showType: "attachment", id: A.value, onClose: e[12] || (e[12] = (v) => I.value = false) }, null, 8, ["isVisible", "id"])) : H("", true)]), _: 1 }, 8, ["modelValue"]);
  };
} }, xt = De(mt, [["__scopeId", "data-v-9b1baf0a"]]);
export {
  xt as default
};
