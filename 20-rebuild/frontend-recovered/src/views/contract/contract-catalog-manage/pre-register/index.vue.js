import { useStore as N } from "vuex";
import { ref as m } from "vue";
import { computed as x } from "vue";
import { watch as S } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as R } from "vue";
import { createVNode as c } from "vue";
import { unref as t } from "vue";
import { withDirectives as C } from "vue";
import { createBlock as o } from "vue";
import { withCtx as D } from "vue";
import { createCommentVNode as r } from "vue";
import { ElTableColumn as A } from "element-plus";
import { vLoading as T } from "element-plus";
import { _ as P, i1 as B, i0 as E, ib as H, x as W, ic as j, o as I, P as O, id as F, ie as L, b as isEmpty, i2 as Q, G as U } from "../../../../shared/runtime.js";
import { f } from "../../../../modules/contract-9b18cc88.js";
import q from "./module/header.vue.js";
const G = { class: "app-container" }, K = { __name: "index", setup(z) {
  const h = { add: true, edit: false, del: false, download: false }, w = N(), d = m(), b = m(), g = x(() => [["applicationDate", ["parse-time", "{y}-{m}-{d} {h}:{i}"]], ["signDate", ["parse-time", "{y}-{m}-{d} {h}:{i}"]], ["boolBidWinningNotice", ["parse-enum", B]], ["infoSource", ["parse-enum", E]], ["reviewPassTime", ["parse-time", "{y}-{m}-{d} {h}:{i}"]], ["contractAmount", ["to-thousand", 2]], ["reviewStatus", ["parse-enum", H]]]), { crud: n, columns: i, CRUD: v } = W({ title: "合同预登记", sort: [], permission: { ...f }, crudApi: j, invisibleColumns: [], optShow: { ...h } }, d);
  S(() => w.state.approval_list.approvalNum, () => {
    n.refresh();
  });
  const { maxHeight: y } = I({ paginate: true });
  function canQuote(row) {
    const record = row.sourceRow ?? row;
    return record.reviewStatus === H.PASS.V &&
      !record.boolQuote &&
      isEmpty(record.contractNumber) &&
      record.contractCatalogueStatus !== Q.CANCEL.V &&
      (n.selections.length === 0 || n.selections.some((selected) => selected.id === record.id));
  }
  v.HOOK.handleRefresh = (s, { data: u }) => {
    u.content.forEach((e) => {
      const l = [];
      return e.countryValue && l.push(e.countryValue), e.provinceValue && l.push(e.provinceValue), e.cityValue && l.push(e.cityValue), e.address = l.join("/"), e;
    });
  };
  function k(s) {
    U(f.detail) && n.toDetail(s);
  }
  return (s, u) => {
    const e = A, l = V("common-table"), p = T;
    return a(), R("div", G, [c(t(q), { ref_key: "headerRef", ref: b }, null, 512), C((a(), o(l, { ref_key: "tableRef", ref: d, "data-format": g.value, data: t(n).data, style: { width: "100%" }, "max-height": t(y), onSelectionChange: t(n).selectionChangeHandler, onRowDblclick: k, class: "hidden-table-check-all" }, { default: D(() => [c(e, { key: "selection", type: "selection", width: "55", selectable: canQuote }), c(e, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), t(i).visible("preRegistrationNo") ? (a(), o(e, { key: "preRegistrationNo", prop: "preRegistrationNo", "show-overflow-tooltip": true, label: "预登记单号", align: "center", width: "130", fixed: "left" })) : r("", true), t(i).visible("partyName") ? (a(), o(e, { key: "partyName", prop: "partyName", "show-overflow-tooltip": true, label: "甲方或业主名称", align: "center", "min-width": "130", fixed: "left" })) : r("", true), t(i).visible("projectName") ? (a(), o(e, { key: "projectName", prop: "projectName", "show-overflow-tooltip": true, label: "项目名称", align: "center", "min-width": "180", fixed: "left" })) : r("", true), t(i).visible("signerName") ? (a(), o(e, { key: "signerName", prop: "signerName", "show-overflow-tooltip": true, label: "签订人", align: "center", width: "100", fixed: "left" })) : r("", true), t(i).visible("contractAmount") ? (a(), o(e, { key: "contractAmount", prop: "contractAmount", "show-overflow-tooltip": true, label: "合同金额", "min-width": "130", align: "right" })) : r("", true), t(i).visible("address") ? (a(), o(e, { key: "address", prop: "address", "show-overflow-tooltip": true, label: "工程所在地", align: "center", "min-width": "120" })) : r("", true), t(i).visible("boolBidWinningNotice") ? (a(), o(e, { key: "boolBidWinningNotice", prop: "boolBidWinningNotice", "show-overflow-tooltip": true, label: "中标通知书", align: "center", width: "90" })) : r("", true), t(i).visible("partyTypeValue") ? (a(), o(e, { key: "partyTypeValue", prop: "partyTypeValue", "show-overflow-tooltip": true, label: "甲方类别", align: "center" })) : r("", true), t(i).visible("structureTypeValue") ? (a(), o(e, { key: "structureTypeValue", prop: "structureTypeValue", "show-overflow-tooltip": true, label: "结构类型", align: "center" })) : r("", true), t(i).visible("structureArea") ? (a(), o(e, { key: "structureArea", prop: "structureArea", "show-overflow-tooltip": true, label: "建筑面积(平方米)", "min-width": "120", align: "center" })) : r("", true), t(i).visible("contractualNatureValue") ? (a(), o(e, { key: "contractualNatureValue", prop: "contractualNatureValue", "show-overflow-tooltip": true, label: "承包性质", align: "center" })) : r("", true), t(i).visible("infoSource") ? (a(), o(e, { key: "infoSource", prop: "infoSource", "show-overflow-tooltip": true, label: "信息来源", align: "center", "min-width": "130" })) : r("", true), t(i).visible("remark") ? (a(), o(e, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "说明", align: "center", "min-width": "100" })) : r("", true), t(i).visible("applicationDate") ? (a(), o(e, { key: "applicationDate", prop: "applicationDate", "show-overflow-tooltip": true, label: "申请时间", align: "center", width: "150" })) : r("", true), t(i).visible("applicantName") ? (a(), o(e, { key: "applicantName", prop: "applicantName", "show-overflow-tooltip": true, label: "申请人", align: "center", width: "100" })) : r("", true), t(i).visible("reviewStatus") ? (a(), o(e, { key: "reviewStatus", prop: "reviewStatus", "show-overflow-tooltip": true, label: "审批状态", align: "center", fixed: "right" })) : r("", true), t(i).visible("reviewPassTime") ? (a(), o(e, { key: "reviewPassTime", prop: "reviewPassTime", "show-overflow-tooltip": true, label: "审批通过时间", align: "center", width: "150", fixed: "right" })) : r("", true)]), _: 1 }, 8, ["data-format", "data", "max-height", "onSelectionChange"])), [[p, t(n).loading]]), c(t(O)), c(t(F)), c(t(L), { onSubmitSuccess: t(n).toQuery }, null, 8, ["onSubmitSuccess"])]);
  };
} }, $ = P(K, [["__scopeId", "data-v-0a85875e"]]);
export {
  $ as default
};
