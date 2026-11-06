import { computed as v } from "vue";
import { ref as b } from "vue";
import { watch as M } from "vue";
import { nextTick as q } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as le } from "vue";
import { createVNode as y } from "vue";
import { unref as i } from "vue";
import { withDirectives as oe } from "vue";
import { createBlock as s } from "vue";
import { withCtx as f } from "vue";
import { createTextVNode as h } from "vue";
import { createCommentVNode as c } from "vue";
import { createElementVNode as ne } from "vue";
import { ElTableColumn as ie } from "element-plus";
import { ElTag as re } from "element-plus";
import { ElPopconfirm as se } from "element-plus";
import { vLoading as de } from "element-plus";
import { l as m, _ as ue, aa as N, x as ce, tc as F, td as H, o as pe, tl as V, G as x, L as me, P as fe, tm as ge, tn as ye } from "../../../../../../../shared/runtime.js";
import we from "./module/header.vue.js";
import be from "../OAModal.vue.js";
import "../../../../../../../modules/plan-d12d7ccf.js";
import "../../../components/drawing-upload-btn.vue.js";
import "../../../../../../../modules/index-ce9deea8.js";
function ve(a) {
  return m({ module: "plan", url: "drawing/weld/map/contrast", method: "get", params: a });
}
function he(a) {
  return m({ module: "plan", url: "drawing/deepen/weld/map/delete", method: "delete", data: a });
}
function _e(a) {
  return m({ module: "plan", url: "drawing/download/weld/map", method: "get", responseType: "blob", params: a });
}
function Te(a) {
  return m({ module: "plan", url: "drawing/struct/mark/map/update", method: "put", timeout: 6e6, headers: { "Content-Type": "multipart/form-data" }, data: a });
}
function ke(a) {
  return m({ module: "plan", url: "drawing/weld/map/contrast/download", method: "get", responseType: "blob", params: a });
}
const xe = { get: ve, del: he, update: Te, fileSingleDownloadApi: _e, fileMatchingDetailsDownload: ke };
function Ae(a) {
  return m({ module: "plan", url: "drawing/weld/contrast", method: "get", params: a });
}
function De(a) {
  return m({ module: "plan", url: "drawing/deepen/mark/delete", method: "delete", data: a });
}
function Ce(a) {
  return m({ module: "plan", url: "drawing/download/mark", method: "get", responseType: "blob", params: a });
}
function Ne(a) {
  return m({ module: "plan", url: "drawing/struct/mark/update", method: "put", timeout: 6e6, headers: { "Content-Type": "multipart/form-data" }, data: a });
}
function Se(a) {
  return m({ module: "plan", url: "drawing/weld/contrast/download", method: "get", responseType: "blob", params: a });
}
const Ie = { get: Ae, del: De, update: Ne, fileSingleDownloadApi: Ce, fileMatchingDetailsDownload: Se };
const $e = { class: "detail-right-container" }, Re = { class: "btn" }, Me = { __name: "index", props: { currentRow: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["success"], setup(a, { expose: P, emit: O }) {
  const B = v(() => N.ARTIFACT.V | N.ASSEMBLY.V | N.MACHINE_PART.V), Q = O, S = a, j = { add: false, edit: false, del: false, download: false }, w = b(), _ = b(), I = b({}), T = b(false), U = b([["createTime", "parse-time"], ["updateTime", "parse-time"]]), { CRUD: A, crud: o, columns: g } = ce({ title: "XML文件匹配详情", permission: { ...S.permission }, optShow: { ...j }, crudApi: { get: F, del: H }, requiredQuery: ["monomerId"], invisibleColumns: ["userName", "createTime"], queryOnPresenterCreated: false, hasPagination: true }, _), { maxHeight: L } = pe({ wrapperBox: ".detail-right-container", extraBox: ".detail-right-container .head-container", navbar: false, paginate: true, extraHeight: 190 }), D = v(() => {
    var e;
    return (e = w.value) == null ? void 0 : e.uploadType;
  }), G = v(() => {
    var e;
    return (e = w.value) == null ? void 0 : e.uploadFormat;
  }), C = v(() => {
    var e;
    return (e = w.value) == null ? void 0 : e.delIdField;
  }), K = v(() => {
    var l, n, p;
    let e = { get: F, del: H, fileSingleDownloadApi: ge, fileMatchingDetailsDownload: ye };
    const t = ((l = w.value) == null ? void 0 : l.uploadTypeOptions) || [];
    return D.value === ((n = t == null ? void 0 : t[1]) == null ? void 0 : n.id) ? e = xe : D.value === ((p = t == null ? void 0 : t[2]) == null ? void 0 : p.id) && (e = Ie), e;
  });
  M(() => D.value, (e) => {
    R(), q(() => {
      o.crudApi = { ...K.value }, o.toQuery();
    });
  }), M(() => S.currentRow, (e = {}) => {
    q(() => {
      o.query.projectId = e.projectId, o.query.monomerId = e.monomerId, o.query.dataType = e.dataType, o.query.productType = e.productType, o.query.steelPlateTypeEnum = e.steelPlateTypeEnum, o.toQuery();
    });
  }, { immediate: true, deep: true }), A.HOOK.handleRefresh = (e, { data: { content: t = [] } }) => {
    var l;
    t.forEach((n, p) => {
      var k;
      n.id = n.serialNumber + `_${p}_${C.value}_` + ((k = n == null ? void 0 : n[C.value]) == null ? void 0 : k[0]), n.selectable = !!n.sign;
    }), (l = d.value) != null && l.length && d.value.forEach((n) => {
      var p;
      (p = _.value.$refs.tableRef) == null || p.toggleRowSelection(n, true);
    });
  }, A.HOOK.beforeToQuery = () => o.query.productType !== B.value, A.HOOK.afterDelete = () => {
    $();
  };
  function z(e, t) {
    const l = d.value.findIndex((n) => n.id === t.id);
    l !== -1 ? d.value.splice(l, 1) : d.value.push(t);
  }
  function Z(e) {
    const t = _.value.$refs.tableRef.store.states.isAllSelected;
    if (console.log(t), t.value) d.value = Array.from(/* @__PURE__ */ new Set([...d.value, ...e]));
    else {
      const l = o.data.map((n) => n.id);
      d.value = d.value.filter((n) => !l.includes(n.id));
    }
  }
  function $() {
    o.toQuery(), Q("success");
  }
  function X(e) {
    return e.sign === V.MATCHING.V;
  }
  const d = b([]);
  async function Y(e) {
    try {
      await o.crudApi.del({ ids: e == null ? void 0 : e[C.value] }), o.notify("操作成功", "success"), o.toQuery();
    } catch (t) {
      console.log(t);
    }
  }
  function R() {
    d.value = [];
  }
  function J() {
    var e;
    (e = w.value) == null || e.initUploadType();
  }
  function W(e) {
    I.value = { ...e }, T.value = true;
  }
  return P({ crud: o, selectedIds: d, initUploadType: J, clearSelectIds: R }), (e, t) => {
    const l = ie, n = re, p = E("common-button"), k = se, ee = E("common-table"), te = de;
    return r(), le("div", $e, [y(i(we), { ref_key: "headRef", ref: w, selectedIds: d.value, class: "head-container", onClear: t[0] || (t[0] = (u) => d.value = []) }, null, 8, ["selectedIds"]), oe((r(), s(ee, { ref_key: "tableRef", ref: _, data: i(o).data, "data-format": U.value, "empty-text": i(o).emptyText, "max-height": i(L), "row-key": "id", style: { width: "100%" }, onSelect: z, onSelectAll: Z }, { default: f(() => [y(l, { "reserve-selection": true, selectable: X, align: "center", type: "selection", width: "55" }), y(l, { align: "center", label: "匹配状态", width: "120" }, { default: f(({ row: u }) => [u.sign === i(V).MATCHING.V ? (r(), s(n, { key: 0, type: "success", "disable-transitions": "" }, { default: f(() => t[3] || (t[3] = [h("匹配")])), _: 1, __: [3] })) : (r(), s(n, { key: 1, type: "danger", "disable-transitions": "" }, { default: f(() => t[4] || (t[4] = [h("未匹配")])), _: 1, __: [4] }))]), _: 1 }), y(l, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), i(g).visible("areaName") ? (r(), s(l, { key: "areaName", align: "left", label: "区域", prop: "areaName", "show-overflow-tooltip": "" })) : c("", true), i(g).visible("serialNumber") ? (r(), s(l, { key: "serialNumber", align: "center", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" })) : c("", true), i(g).visible("specification") ? (r(), s(l, { key: "specification", align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" })) : c("", true), i(g).visible("quantity") ? (r(), s(l, { key: "quantity", align: "center", label: "清单数量", prop: "quantity", "show-overflow-tooltip": "" })) : c("", true), i(g).visible("userName") ? (r(), s(l, { key: "userName", align: "center", label: "创建人", prop: "userName", "show-overflow-tooltip": "" })) : c("", true), i(g).visible("createTime") ? (r(), s(l, { key: "createTime", align: "center", label: "创建时间", prop: "createTime", "show-overflow-tooltip": "" })) : c("", true), i(g).visible("updateTime") ? (r(), s(l, { key: "updateTime", align: "center", label: "最近操作时间", prop: "updateTime", "show-overflow-tooltip": "" })) : c("", true), i(x)([...a.permission.import, ...a.permission.del, ...a.permission.drawingZipDownload]) ? (r(), s(l, { key: 7, align: "center", fixed: "right", label: "操作", width: "300" }, { default: f((u) => [ne("div", Re, [i(x)(a.permission.drawingZipDownload) ? (r(), s(me, { key: 0, disabled: !u.row.sign, fn: i(o).crudApi.fileSingleDownloadApi, params: { ...i(o).query, serialNumber: u.row.serialNumber, taskTypeEnum: i(o).query.productType }, responseHeaderResult: true, boolDrawing: "", size: "default", type: "warning" }, { default: f(() => t[5] || (t[5] = [h(" 下载 ")])), _: 2, __: [5] }, 1032, ["disabled", "fn", "params"])) : c("", true), i(x)(a.permission.import) ? (r(), s(p, { key: 1, disabled: !u.row.sign, size: "default", type: "primary", onClick: (ae) => W(u.row) }, { default: f(() => t[6] || (t[6] = [h(" 覆盖导入 ")])), _: 2, __: [6] }, 1032, ["disabled", "onClick"])) : c("", true), i(x)(a.permission.del) ? (r(), s(k, { key: 2, "confirm-button-text": "确定", "cancel-button-text": "取消", "icon-color": "red", title: "确定解除匹配吗?", onConfirm: (ae) => Y(u.row) }, { reference: f(() => [y(p, { disabled: !u.row.sign, type: "danger" }, { default: f(() => t[7] || (t[7] = [h(" 解除匹配 ")])), _: 2, __: [7] }, 1032, ["disabled"])]), _: 2 }, 1032, ["onConfirm"])) : c("", true)])]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[te, i(o).loading]]), y(i(fe)), y(be, { visible: T.value, "onUpdate:visible": t[1] || (t[1] = (u) => T.value = u), "row-data": I.value, "upload-type": G.value, cover: true, onSuccess: $, onClose: t[2] || (t[2] = () => T.value = false) }, null, 8, ["visible", "row-data", "upload-type"])]);
  };
} }, Be = ue(Me, [["__scopeId", "data-v-47760fec"]]);
export {
  Be as default
};
