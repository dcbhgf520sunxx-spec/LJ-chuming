import { ref as N } from "vue";
import { watch as h } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as A } from "vue";
import { createVNode as t } from "vue";
import { withCtx as a } from "vue";
import { createTextVNode as u } from "vue";
import { toDisplayString as l } from "vue";
import { unref as o } from "vue";
import { createElementVNode as d } from "vue";
import { createBlock as m } from "vue";
import { createCommentVNode as f } from "vue";
import { ElDescriptionsItem as j } from "element-plus";
import { ElDescriptions as S } from "element-plus";
import { ElDivider as w } from "element-plus";
import { _ as T, jq as I, c7 as x, aN as B, bN as C, gD as E, jA as V, p, ix as F, S as k, R } from "../../../shared/runtime.js";
const L = { id: "baseContainer" }, M = { __name: "zn-base", props: { projectId: { type: [Number, String], default: void 0 } }, setup(v, { expose: b }) {
  const e = N({}), c = v;
  h(() => c.projectId, (s) => {
    _();
  }, { deep: true, immediate: true });
  async function _() {
    if (!c.projectId) return;
    let s = {};
    try {
      const r = await I(c.projectId);
      s = JSON.parse(JSON.stringify(r)), s.startDate = s.startDate ? String(s.startDate) : "", s.endDate = s.endDate ? String(s.endDate) : "", s.totalDuration = s.startDate && s.endDate ? x(s.startDate, s.endDate) : "", s.managementFee = s.managementFeeRate && s.contractAmount ? s.managementFeeRate * s.contractAmount / 100 : "", s.attachments = s.attachments || [], s.attachmentFiles = s.attachments, s.region = B([s.countryId, s.provinceId, s.cityId, s.regionId]);
    } catch (r) {
      console.log("error", r);
    } finally {
      e.value = s;
    }
  }
  return b({ detail: e, fetchDetail: _ }), (s, r) => {
    const n = j, y = S, g = w;
    return i(), A("div", L, [t(y, { column: 3, border: "" }, { default: a(() => [t(n, { label: "项目编号" }, { default: a(() => [u(l(e.value.serialNumber), 1)]), _: 1 }), t(n, { label: "项目名称" }, { default: a(() => [u(l(e.value.name), 1)]), _: 1 }), t(n, { label: "项目简称" }, { default: a(() => [u(l(e.value.shortName), 1)]), _: 1 }), t(n, { label: "订单类型" }, { default: a(() => [u(l(o(C).VL[e.value.businessType]), 1)]), _: 1 }), t(n, { label: "经营方式" }, { default: a(() => [u(l(o(E).VL[e.value.projectAttribute]), 1)]), _: 1 }), t(n, { label: "承接部门" }, { default: a(() => [u(l(e.value.deptName), 1)]), _: 1 }), t(n, { label: "结构工程量" }, { default: a(() => [u(l(e.value.structureArea) + " ", 1), d("span", null, l(e.value.unitType === 1 ? "吨" : "㎡"), 1)]), _: 1 }), t(n, { label: "项目经理" }, { default: a(() => [u(l(e.value.projectManagerName), 1)]), _: 1 }), t(n, { label: "销售负责人" }, { default: a(() => [u(l(e.value.salesLeaderName), 1)]), _: 1 }), t(n, { label: "项目地点" }, { default: a(() => [u(l(e.value.regionalFullName), 1)]), _: 1 }), t(n, { label: "详细地址", span: "2" }, { default: a(() => [u(l(e.value.address), 1)]), _: 1 }), t(n, { label: "结构类型" }, { default: a(() => [u(l(e.value.structureStatusName), 1)]), _: 1 }), t(n, { label: "甲方类型" }, { default: a(() => [u(l(e.value.partyTypeName), 1)]), _: 1 }), t(n, { label: "发包类型" }, { default: a(() => [u(l(e.value.sendingModeName), 1)]), _: 1 }), t(n, { label: "合同签订主体" }, { default: a(() => [u(l(e.value.customerUnit), 1)]), _: 1 }), t(n, { label: "装配式建筑" }, { default: a(() => [u(l(o(V).VL[e.value.isBuilding]), 1)]), _: 1 }), t(n, { label: "信息来源", span: "2" }, { default: a(() => [u(l(e.value.infoSourceName), 1)]), _: 1 }), t(n, { label: "合同额" }, { default: a(() => [u(l(e.value.contractAmount), 1)]), _: 1 }), t(n, { label: "税率" }, { default: a(() => [u(l(e.value.taxRate), 1)]), _: 1 }), t(n, { label: "币种" }, { default: a(() => [u(l(e.value.currencyTypeName), 1)]), _: 1 }), e.value.projectAttribute === 2 ? (i(), m(n, { key: 0, label: "签约主体占比" }, { default: a(() => [u(l(e.value.contractSignBodyScale) + "% ", 1)]), _: 1 })) : f("", true), e.value.projectAttribute === 2 ? (i(), m(n, { key: 1, span: 2, label: "项目经理占比" }, { default: a(() => [u(l(e.value.projectManagerScale) + "% ", 1)]), _: 1 })) : f("", true), t(n, { label: "履约保证金" }, { default: a(() => [u(l(e.value.marginAmount), 1)]), _: 1 }), t(n, { label: "保证金类型", span: "2" }, { default: a(() => [u(l(e.value.marginType), 1)]), _: 1 }), t(n, { label: "开工日期" }, { default: a(() => [d("span", null, l(e.value.startDate ? o(p)(e.value.startDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), t(n, { label: "完工日期" }, { default: a(() => [d("span", null, l(e.value.endDate ? o(p)(e.value.endDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), t(n, { label: "总工期（天）" }, { default: a(() => [u(l(e.value.allDays), 1)]), _: 1 }), t(n, { label: "发包单位", span: "3" }, { default: a(() => [u(l(e.value.contractSignBodyName), 1)]), _: 1 }), t(n, { label: "付款方式", span: "3" }, { default: a(() => [u(l(e.value.commercialClause), 1)]), _: 1 }), t(n, { label: "技术条款", span: "3" }, { default: a(() => [u(l(e.value.technologyClause), 1)]), _: 1 }), t(n, { label: "其他说明", span: "3" }, { default: a(() => [u(l(e.value.otherRemarks), 1)]), _: 1 })]), _: 1 }), t(g, null, { default: a(() => r[1] || (r[1] = [d("span", { class: "title" }, "合同附件", -1)])), _: 1, __: [1] }), t(R, { files: e.value.attachmentFiles, "onUpdate:files": r[0] || (r[0] = (D) => e.value.attachmentFiles = D), "download-fn": o(F), "file-classify": o(k).CONTRACT_ATT.V, uploadable: false, "empty-text": "暂未上传合同附件", "show-download": "", showView: "" }, null, 8, ["files", "download-fn", "file-classify"])]);
  };
} }, J = T(M, [["__scopeId", "data-v-ec6163d7"]]);
export {
  J as default
};
