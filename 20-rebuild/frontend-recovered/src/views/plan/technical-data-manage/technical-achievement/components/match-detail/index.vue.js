import { ref as _ } from "vue";
import { watch as E } from "vue";
import { nextTick as H } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as O } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as M } from "vue";
import { createVNode as u } from "vue";
import { unref as t } from "vue";
import { withDirectives as w } from "vue";
import { createBlock as n } from "vue";
import { withCtx as m } from "vue";
import { createCommentVNode as r } from "vue";
import { createTextVNode as T } from "vue";
import { createElementVNode as Q } from "vue";
import { ElMessageBox as V } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { ElTag as $ } from "element-plus";
import { vLoading as A } from "element-plus";
import { _ as F, x as K, tc as L, td as U, o as G, G as v, te as X, P as J } from "../../../../../../shared/runtime.js";
import W from "../drawing-upload-btn.vue.js";
import Y from "./module/header.vue.js";
import "../../../../../../modules/index-ce9deea8.js";
const Z = { class: "detail-container" }, ee = { class: "btn" }, te = { __name: "index", props: { currentRow: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, uploadType: { type: String, default: ".pdf" }, tip: { type: String, default: "覆盖导入仅支持PDF格式" } }, emits: ["success"], setup(d, { emit: x }) {
  const k = x, p = d, I = { add: false, edit: false, del: true, download: false }, y = _(), N = _([["createTime", "parse-time"], ["updateTime", "parse-time"]]), { CRUD: f, crud: o, columns: l } = K({ title: "XML文件匹配详情", permission: { ...p.permission }, optShow: { ...I }, crudApi: { get: L, del: U }, requiredQuery: ["monomerId"], invisibleColumns: [], hasPagination: true }, y), { maxHeight: C } = G({ wrapperBox: ".detail-container", extraBox: ".detail-container .head-container", navbar: false, paginate: true, extraHeight: 190 });
  E(() => p.currentRow, (e = {}) => {
    H(() => {
      o.query.projectId = e.projectId, o.query.monomerId = e.monomerId, o.query.areaId = e.areaId, o.query.dataType = e.dataType, o.query.productType = e.productType, o.query.steelPlateTypeEnum = e.steelPlateTypeEnum, o.toQuery();
    });
  }, { immediate: true, deep: true }), f.HOOK.handleRefresh = (e, { data: { content: s = [] } }) => {
    s.forEach((a) => {
      a.id = { ids: a.drawingID || [] }, a.selectable = !!a.sign;
    });
  }, f.HOOK.afterDelete = () => {
    b();
  };
  function q(e) {
    return { productId: e.productId, projectId: e.projectId, monomerId: e.monomerId, areaId: e.areaId, productType: e.productType, dataType: e.dataType };
  }
  function b() {
    o.toQuery(), k("success");
  }
  function D(e) {
    return e.selectable;
  }
  async function B(e) {
    try {
      await V.confirm("是否确认删除数据", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await o.crudApi.del({ ids: e.drawingID }), o.notify("操作成功", "success"), o.toQuery();
    } catch (s) {
      console.log(s);
    }
  }
  return (e, s) => {
    const a = z, g = $, P = h("common-button"), R = h("common-table"), S = O("permission"), j = A;
    return i(), M("div", Z, [u(t(Y), { tip: p.tip, class: "head-container" }, null, 8, ["tip"]), w((i(), n(R, { ref_key: "tableRef", ref: y, data: t(o).data, "data-format": N.value, "empty-text": t(o).emptyText, "max-height": t(C), style: { width: "100%" }, onSelectionChange: t(o).selectionChangeHandler }, { default: m(() => [u(a, { selectable: D, align: "center", type: "selection", width: "55" }), u(a, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), t(l).visible("areaName") ? (i(), n(a, { key: "areaName", align: "center", label: "区域", prop: "areaName", "show-overflow-tooltip": "" })) : r("", true), t(l).visible("serialNumber") ? (i(), n(a, { key: "serialNumber", align: "center", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" })) : r("", true), t(l).visible("specification") ? (i(), n(a, { key: "specification", align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" })) : r("", true), t(l).visible("quantity") ? (i(), n(a, { key: "quantity", align: "center", label: "清单数量", prop: "quantity", "show-overflow-tooltip": "" })) : r("", true), t(l).visible("userName") ? (i(), n(a, { key: "userName", align: "center", label: "创建者", prop: "userName", "show-overflow-tooltip": "" })) : r("", true), t(l).visible("createTime") ? (i(), n(a, { key: "createTime", align: "center", label: "创建时间", prop: "createTime", "show-overflow-tooltip": "" })) : r("", true), t(l).visible("updateTime") ? (i(), n(a, { key: "updateTime", align: "center", label: "编辑时间", prop: "updateTime", "show-overflow-tooltip": "" })) : r("", true), t(l).visible("selectable") ? (i(), n(a, { key: "selectable", align: "center", label: "匹配状态", prop: "selectable", "show-overflow-tooltip": "", width: "100" }, { default: m((c) => [c.row.selectable ? (i(), n(g, { key: 0, size: "large", type: "success" }, { default: m(() => s[0] || (s[0] = [T("匹配成功")])), _: 1, __: [0] })) : (i(), n(g, { key: 1, size: "large", type: "danger" }, { default: m(() => s[1] || (s[1] = [T("未上传")])), _: 1, __: [1] }))]), _: 1 })) : r("", true), t(v)([...d.permission.import, ...d.permission.detail]) ? (i(), n(a, { key: 8, align: "center", fixed: "right", label: "操作", width: "170px" }, { default: m((c) => [Q("div", ee, [w(u(W, { accept: p.uploadType, data: q(c.row), dataType: c.row.dataType, disabled: !c.row.selectable, successMsg: "审批流已生成!请点击审批记录查看", tip: p.uploadType, "upload-fun": t(X), "btn-name": "覆盖导入", size: "default", type: "primary", onSuccess: b }, null, 8, ["accept", "data", "dataType", "disabled", "tip", "upload-fun"]), [[S, d.permission.import]]), t(v)(d.permission.del) ? (i(), n(P, { key: 0, icon: "el-icon-delete", disabled: !c.row.selectable, type: "danger", onClick: (ae) => B(c.row) }, null, 8, ["disabled", "onClick"])) : r("", true)])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height", "onSelectionChange"])), [[j, t(o).loading]]), u(t(J))]);
  };
} }, se = F(te, [["__scopeId", "data-v-558c012d"]]);
export {
  se as default
};
