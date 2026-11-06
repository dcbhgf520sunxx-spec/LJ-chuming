import { useStore as re } from "vuex";
import { ref as c } from "vue";
import { provide as ue } from "vue";
import { watch as pe } from "vue";
import { onMounted as de } from "vue";
import { resolveComponent as U } from "vue";
import { resolveDirective as ce } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as p } from "vue";
import { createElementVNode as V } from "vue";
import { createVNode as d } from "vue";
import { unref as e } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as l } from "vue";
import { withCtx as u } from "vue";
import { createCommentVNode as r } from "vue";
import { Fragment as C } from "vue";
import { renderList as O } from "vue";
import { toDisplayString as S } from "vue";
import { createTextVNode as h } from "vue";
import { withModifiers as j } from "vue";
import { ElMessage as me } from "element-plus";
import { ElTableColumn as fe } from "element-plus";
import { ElTooltip as ve } from "element-plus";
import { ElPopover as _e } from "element-plus";
import { vLoading as ye } from "element-plus";
import { c as $ } from "../../../../../modules/process-611d795f.js";
import { _ as we, ts as be, tt as he, x as ge, o as ke, t0 as L, i as Ce, z as A, G as z, P as Se, iy as Pe } from "../../../../../shared/runtime.js";
import { u as v } from "../../../../../modules/plan-d12d7ccf.js";
import xe from "./module/detail.vue.js";
import Ne from "./module/modify-form.vue.js";
import Re from "./module/artifact-bind-form.vue.js";
import Te from "./module/form.vue.js";
import Ve from "./module/header.vue.js";
import "./module/history-version.vue.js";
import "./module/artifact-bind-detail.vue.js";
import "../../../../../modules/UploadBtn-b4cfb47a.js";
import "../../../../../modules/judgeSameValue-9683bdce.js";
import "./module/structure-type.vue.js";
import "./module/artifact-bind-current.vue.js";
import "../../../../supply-chain/components/audit-records.vue.js";
const je = { class: "app-container" }, Le = { class: "head-container" }, De = { key: 1 }, Ee = ["onDblclick"], Qe = { key: 1 }, Me = { style: { display: "inline-block", "margin-left": "6px" } }, Ue = { key: 0, style: { "text-align": "right", margin: "0" } }, Oe = { __name: "index", setup($e) {
  const y = re(), B = { add: false, edit: false, del: false, download: false }, D = c(), b = c({}), P = c(false), x = c(false), N = c(false), F = c(false), g = c(false), E = c(), Q = c([]);
  ue("structureClassList", Q);
  const H = c([["uploadTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]], ["processType", ["parse-enum", be]], ["boolSingleProject", ["parse-enum", he]]]), { CRUD: I, crud: _, columns: m } = ge({ title: "工艺文件", sort: ["id.desc"], permission: { ...v }, optShow: { ...B }, crudApi: { ...$ }, hasPagination: true, addSuccessText: "审批流已生成!请点击审批记录查看" }, D), { maxHeight: q } = ke({ wrapperBox: ".changeFile", paginate: true, extraHeight: 40 });
  function G(i) {
    Q.value = i;
  }
  function K(i) {
    E.value = i.id, g.value = true;
  }
  function J(i) {
    b.value = i == null ? void 0 : i.sourceRow, x.value = true;
  }
  function W(i) {
    b.value = i == null ? void 0 : i.sourceRow, P.value = true;
  }
  function X(i) {
    b.value = i == null ? void 0 : i.sourceRow, N.value = true;
  }
  async function Y(i) {
    try {
      await $.del(i.id), me({ type: "success", message: "删除成功" }), _.toQuery();
    } catch {
      console.log("删除工艺文件");
    }
  }
  function Z(i) {
    i.pop = true;
  }
  function ee(i) {
    i.pop = false;
  }
  function M(i) {
    F.value = false;
  }
  function te() {
    setTimeout(() => {
      document.addEventListener("hover", M, { passive: false });
    }, 0);
  }
  function oe() {
    document.removeEventListener("hover", M);
  }
  return I.HOOK.handleRefresh = (i, a) => {
    a.data.content = a.data.content.map((n) => (n.project = n.boolSingleProject ? n.projectList[0] : {}, n));
  }, pe(() => y.state.approval_list.Subprocess_Num, () => {
    _.toQuery();
  }), de(async () => {
    await y.dispatch("approval_list/fetchSubNum", L.PLAN_PROCESS_DOCUMENT.V), await y.dispatch("approval_list/fetchApprovalNum", L.PLAN_PROCESS_DOCUMENT.V), await y.dispatch("approval_list/fetchRejNum", L.PLAN_PROCESS_DOCUMENT.V);
  }), (i, a) => {
    const n = fe, w = U("common-button"), ie = ve, ae = _e, le = U("common-table"), R = ce("permission"), ne = ye;
    return o(), p("div", je, [V("div", Le, [d(e(Ve), { APPtotal: e(y).state.approval_list.APPprocess_Num, "rej-total": e(y).state.approval_list.rejprocess_Num, subTotal: e(y).state.approval_list.Subprocess_Num, onStructureClassChange: G }, null, 8, ["APPtotal", "rej-total", "subTotal"])]), k((o(), l(le, { ref_key: "tableRef", ref: D, data: e(_).data, "data-format": H.value, "empty-text": e(_).emptyText, "max-height": e(q), style: { width: "100%" } }, { default: u(() => [d(n, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), e(m).visible("processType") ? (o(), l(n, { key: "processType", "show-overflow-tooltip": true, align: "center", label: "工艺类型", prop: "processType", width: "80" })) : r("", true), e(m).visible("boolSingleProject") ? (o(), l(n, { key: "boolSingleProject", "show-overflow-tooltip": true, align: "center", label: "文件类型", prop: "boolSingleProject", width: "80" })) : r("", true), e(m).visible("projectList") ? (o(), l(n, { key: "projectList", "show-overflow-tooltip": true, align: "left", label: "所属项目", "min-width": "150", prop: "projectList" }, { default: u((t) => [e(Ce)(t.row.sourceRow.projectList) ? (o(), p(C, { key: 0 }, [t.row.projectList.length === 1 ? (o(true), p(C, { key: 0 }, O(t.row.projectList, (f) => (o(), p("span", { key: f.id }, S(e(A)(f)), 1))), 128)) : (o(true), p(C, { key: 1 }, O(t.row.projectList, (f) => (o(), p("span", { key: f.id }, "【" + S(e(A)(f)) + "】", 1))), 128))], 64)) : (o(), p("span", De, "-"))]), _: 1 })) : r("", true), e(m).visible("fileName") ? (o(), l(n, { key: "fileName", align: "left", label: "文件名称", "min-width": "120", prop: "fileName" }, { default: u((t) => [t.row.attachmentDTO ? (o(), p("div", { key: 0, style: { cursor: "pointer", color: "#409eff" }, onDblclick: (f) => K(t.row.attachmentDTO) }, S(t.row.fileName), 41, Ee)) : (o(), p("span", Qe, "-"))]), _: 1 })) : r("", true), e(m).visible("remark") ? (o(), l(n, { key: "remark", "show-overflow-tooltip": true, align: "left", label: "备注", "min-width": "120", prop: "remark" })) : r("", true), e(m).visible("bindQuantity") ? (o(), l(n, { key: "bindQuantity", "show-overflow-tooltip": true, align: "left", label: "绑定构件数量", prop: "bindQuantity", width: "100" })) : r("", true), e(m).visible("fileVersion") ? (o(), l(n, { key: "fileVersion", "show-overflow-tooltip": true, align: "center", label: "修订版本", prop: "fileVersion", width: "80" })) : r("", true), e(m).visible("uploadTime") ? (o(), l(n, { key: "uploadTime", align: "center", label: "上传日期", prop: "uploadTime", width: "140" })) : r("", true), e(m).visible("userName") ? (o(), l(n, { key: "userName", "show-overflow-tooltip": true, align: "center", label: "上传人", prop: "userName", width: "90" })) : r("", true), e(z)([...e(v).detail, ...e(v).edit, ...e(v).bind, ...e(v).del]) ? (o(), l(n, { key: 9, align: "center", fixed: "right", label: "操作", width: "300px" }, { default: u((t) => {
      var f;
      return [k((o(), l(w, { size: "default", onClick: (s) => J(t.row) }, { default: u(() => a[4] || (a[4] = [h("详情 ")])), _: 2, __: [4] }, 1032, ["onClick"])), [[R, e(v).detail]]), k((o(), l(w, { size: "default", type: "primary", onClick: (s) => W(t.row) }, { default: u(() => a[5] || (a[5] = [h("修改 ")])), _: 2, __: [5] }, 1032, ["onClick"])), [[R, e(v).edit]]), k((o(), l(w, { size: "default", type: "success", onClick: (s) => X(t.row) }, { default: u(() => a[6] || (a[6] = [h(" 绑定构件 ")])), _: 2, __: [6] }, 1032, ["onClick"])), [[R, e(v).bind]]), e(z)(e(v).del) ? (o(), p(C, { key: 0 }, [((f = t.row.sourceRow) == null ? void 0 : f.bindQuantity) > 0 ? (o(), l(ie, { key: 0, content: "已绑定构件，不可删除!", effect: "light", placement: "top" }, { default: u(() => {
        var s;
        return [V("div", Me, [d(w, { disabled: ((s = t.row.sourceRow) == null ? void 0 : s.bindQuantity) > 0, icon: "el-icon-delete", size: "default", type: "danger" }, null, 8, ["disabled"])])];
      }), _: 2 }, 1024)) : (o(), l(ae, { key: 1, visible: t.row.pop, "onUpdate:visible": (s) => t.row.pop = s, placement: "top", trigger: "manual", width: "180", onHide: oe, onShow: te }, { reference: u(() => {
        var s;
        return [d(w, { disabled: ((s = t.row.sourceRow) == null ? void 0 : s.bindQuantity) > 0, icon: "el-icon-delete", size: "default", type: "danger", onClick: j((T) => Z(t.row), ["stop"]) }, null, 8, ["disabled", "onClick"])];
      }), default: u(() => {
        var s, T;
        return [V("p", null, S(((s = t.row.sourceRow) == null ? void 0 : s.bindQuantity) > 0 ? "已绑定构件，不可删除!" : "确定删除？"), 1), ((T = t.row.sourceRow) == null ? void 0 : T.bindQuantity) <= 0 ? (o(), p("div", Ue, [d(w, { size: "default", link: "", type: "primary", onClick: j((se) => ee(t.row), ["stop"]) }, { default: u(() => a[7] || (a[7] = [h("取消")])), _: 2, __: [7] }, 1032, ["onClick"]), d(w, { size: "default", type: "primary", onClick: j((se) => Y(t.row), ["stop"]) }, { default: u(() => a[8] || (a[8] = [h("确定")])), _: 2, __: [8] }, 1032, ["onClick"])])) : r("", true)];
      }), _: 2 }, 1032, ["visible", "onUpdate:visible"]))], 64)) : r("", true)];
    }), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[ne, e(_).loading]]), d(e(Se)), d(e(Te)), d(e(xe), { modelValue: x.value, "onUpdate:modelValue": a[0] || (a[0] = (t) => x.value = t), currentRow: b.value, onSuccess: e(_).toQuery }, null, 8, ["modelValue", "currentRow", "onSuccess"]), d(e(Ne), { modelValue: P.value, "onUpdate:modelValue": a[1] || (a[1] = (t) => P.value = t), currentRow: b.value, onSuccess: e(_).toQuery }, null, 8, ["modelValue", "currentRow", "onSuccess"]), d(e(Re), { modelValue: N.value, "onUpdate:modelValue": a[2] || (a[2] = (t) => N.value = t), currentRow: b.value, onSuccess: e(_).toQuery }, null, 8, ["modelValue", "currentRow", "onSuccess"]), g.value ? (o(), l(Pe, { key: 0, id: E.value, isVisible: g.value, showType: "attachment", onClose: a[3] || (a[3] = (t) => g.value = false) }, null, 8, ["id", "isVisible"])) : r("", true)]);
  };
} }, ot = we(Oe, [["__scopeId", "data-v-ec15626b"]]);
export {
  ot as default
};
