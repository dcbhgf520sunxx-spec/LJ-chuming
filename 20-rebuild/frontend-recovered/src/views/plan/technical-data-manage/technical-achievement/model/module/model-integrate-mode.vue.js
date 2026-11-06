import { useStore as W } from "vuex";
import { ref as u } from "vue";
import { provide as I } from "vue";
import { resolveComponent as R } from "vue";
import { resolveDirective as X } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as C } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as n } from "vue";
import { unref as s } from "vue";
import { withDirectives as A } from "vue";
import { createBlock as y } from "vue";
import { withCtx as r } from "vue";
import { toDisplayString as N } from "vue";
import { createTextVNode as x } from "vue";
import { createCommentVNode as Y } from "vue";
import { ElNotification as v } from "element-plus";
import { ElMessageBox as Z } from "element-plus";
import { ElTableColumn as ee } from "element-plus";
import { ElTag as te } from "element-plus";
import { vLoading as ae } from "element-plus";
import { v as ne, t as L, u as se } from "../../../../../../modules/model-0ac957f7.js";
import { t as E } from "../../../../../../modules/plan-d12d7ccf.js";
import { x as oe, o as le, ae as d, a4 as p, t0 as M } from "../../../../../../shared/runtime.js";
import { _ as ie } from "../../../../../../modules/SingleFileUploadBtn-17bec156.js";
import re from "./components/model-integrate-mode-header.vue.js";
const ce = { class: "head-container" }, de = { key: 1 }, ue = { key: 1 }, pe = { style: { display: "flex", "justify-content": "center" } }, Ie = { __name: "model-integrate-mode", props: { projectId: { type: [Number, String], default: void 0 }, info: { type: Object, default: () => {
} } }, emits: ["translate-success"], setup(m, { expose: U, emit: G }) {
  const g = W(), O = G, T = m, w = { add: false, edit: false, del: false, download: false }, S = u(null), V = u(), j = u([["createTime", "parse-time"], ["updateTime", "parse-time"]]), { crud: o, CRUD: D } = oe({ title: "", sort: [], permission: { ...E, get: E.detail }, optShow: { ...w }, crudApi: { get: ne, del: L }, queryOnPresenterCreated: false }, V), { maxHeight: B } = le({ paginate: false }), k = u([]), _ = u(false), h = u(false);
  I("areaIds", k), I("hasProcessingIM", h), I("hasIntegrationModel", _), D.HOOK.handleRefresh = (l, a) => {
    _.value = false, h.value = false, a.data.content = a.data.content.map((e) => (e.hasModelImport = !!e.id, (e.integrationStatus === d.SUCCESS.V || e.integrationStatus === d.PROCESSING.V) && (_.value = true), e.integrationStatus === d.PROCESSING.V && (h.value = true), e));
  }, D.HOOK.beforeToQuery = () => {
    o.query.monomerId = T.info.id;
  };
  function Q(l, a) {
    return !(l.integrationStatus === d.SUCCESS.V || l.integrationStatus === d.PROCESSING.V) && l.hasModelImport;
  }
  function q(l, a) {
    k.value = l.map((e) => e.area.id);
  }
  async function $() {
    var a;
    v({ title: "上传成功", type: "success", message: "审批流已生成!请点击审批记录查看", duration: 2500 }), g.dispatch("approval_list/fetchApprovalNum"), g.dispatch("approval_list/fetchSubNum", M.PLAN_MODEL_DOCUMENT_MANAGE.V), g.dispatch("approval_list/fetchApprovalNum", M.PLAN_MODEL_DOCUMENT_MANAGE.V), g.dispatch("approval_list/fetchRejNum", M.PLAN_MODEL_DOCUMENT_MANAGE.V), await o.toQuery(), ((a = o.data) == null ? void 0 : a.some((e) => (e == null ? void 0 : e.translateStatus) === p.PROCESSING.V || (e == null ? void 0 : e.translateStatus) === p.UPLOAD_PROCESSING.V)) ? (clearInterval(S.value), S.value = setInterval(() => {
      var f;
      o.toQuery(), ((f = o.data) == null ? void 0 : f.every((i) => (i == null ? void 0 : i.translateStatus) !== p.PROCESSING.V && (i == null ? void 0 : i.translateStatus) !== p.UPLOAD_PROCESSING.V)) && (clearInterval(S.value), o.toQuery(), O("translate-success"));
    }, 1e3 * 60)) : O("translate-success");
  }
  async function H(l) {
    Z.confirm(`是否确认删除 “${l.area.name}” 单元下的模型`, "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning" }).then(async () => {
      var a;
      try {
        await L({ monomerId: (a = T.info) == null ? void 0 : a.id, areaId: l.area.id }), v({ title: "删除模型成功", type: "success" }), o.toQuery();
      } catch (e) {
        console.log("删除模型失败", e);
      }
    });
  }
  function z() {
    o.toQuery();
  }
  return U({ fetchData: z }), (l, a) => {
    const e = ee, f = te, i = R("common-button"), F = R("common-table"), K = X("permission"), J = ae;
    return c(), C("div", null, [b("div", ce, [n(s(re), { info: m.info, projectId: m.projectId, queryMonomerId: m.info.id }, null, 8, ["info", "projectId", "queryMonomerId"])]), A((c(), y(F, { ref_key: "tableRef", ref: V, data: s(o).data, "data-format": j.value, "empty-text": s(o).emptyText, "max-height": s(B), style: { width: "100%" }, onSelectionChange: q }, { default: r(() => [n(e, { selectable: Q, align: "center", fixed: "", type: "selection", width: "55" }), n(e, { align: "center", label: "序号", type: "index", width: "60" }), n(e, { align: "center", label: "单元", prop: "area.name" }, { default: r(({ row: t }) => [b("span", null, N(t.area.name), 1)]), _: 1 }), n(e, { align: "center", label: "模型状态", prop: "translateStatus" }, { default: r(({ row: { sourceRow: t } }) => [t.translateStatus ? (c(), y(f, { key: 0, type: s(p).V[t.translateStatus].T, effect: "plain", style: { "margin-left": "5px" } }, { default: r(() => [x(N(s(p).VL[t.translateStatus]), 1)]), _: 2 }, 1032, ["type"])) : (c(), C("span", de, "-"))]), _: 1 }), n(e, { align: "center", label: "集成状态", prop: "integrationStatus" }, { default: r(({ row: { sourceRow: t } }) => [t.integrationStatus ? (c(), y(f, { key: 0, type: s(d).V[t.integrationStatus].T, effect: "plain", style: { "margin-left": "5px" } }, { default: r(() => [x(N(s(d).VL[t.integrationStatus]), 1)]), _: 2 }, 1032, ["type"])) : (c(), C("span", ue, "-"))]), _: 1 }), n(e, { key: "createUserName", align: "center", label: "创建者", prop: "createUserName", "show-overflow-tooltip": "" }), n(e, { key: "createTime", align: "center", label: "创建时间", prop: "createTime", "show-overflow-tooltip": "" }), n(e, { key: "updateTime", align: "center", label: "编辑时间", prop: "updateTime", "show-overflow-tooltip": "" }), n(e, { key: "successQuantity", align: "center", label: "转换成功次数", prop: "successQuantity", "show-overflow-tooltip": "" }), n(e, { align: "center", fixed: "right", label: "操作", width: "170px" }, { default: r(({ row: t }) => {
      var P;
      return [b("div", pe, [n(s(ie), { accept: ".ifc", "btn-name": `${t != null && t.hasModelImport ? "替换模型" : "导入模型"}`, data: { monomerId: (P = m.info) == null ? void 0 : P.id, areaId: t.area.id }, fileClassify: void 0, "upload-fun": s(se), "btn-size": "default", "btn-type": "warning", style: { "margin-right": "5px" }, "success-msg": "模型导入成功", onSuccess: $ }, null, 8, ["btn-name", "data", "upload-fun"]), t != null && t.hasModelImport ? A((c(), y(i, { key: 0, size: "default", style: { "margin-left": "5px" }, type: "danger", onClick: (me) => H(t) }, { default: r(() => a[0] || (a[0] = [x(" 删除 ")])), _: 2, __: [0] }, 1032, ["onClick"])), [[K, s(E).del]]) : Y("", true)])];
    }), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[J, s(o).loading]])]);
  };
} };
export {
  Ie as default
};
