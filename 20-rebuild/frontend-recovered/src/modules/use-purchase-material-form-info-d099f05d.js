import { sR as I, sS as d, cS as w, bl as s, sT as v, sU as L } from "../shared/runtime.js";
import { ref as u } from "vue";
import { watch as W } from "vue";
import { ElMessage as h } from "element-plus";
import { cloneDeep as A } from "lodash";
function P({ props: a, basicClass: i }) {
  const r = u(false), n = u({}), f = u(), { matClsSpec: E, fetchMatClsSpec: y } = I();
  W(() => a.classifyIds, async () => {
    r.value = false, await y(a.classifyIds), r.value = true;
  }, { deep: true, immediate: true });
  const S = async () => {
    if (!r.value) return h.info("请稍后提交，正在加载科目信息"), false;
    if (await f.value.validate()) {
      const t = A(n.value), c = E.value[t.classifyId];
      let l;
      const o = g(a.technologyRow);
      if (c && Array.isArray(c.specList)) {
        for (const m of c.specList) if (o === m.spec) {
          l = m;
          break;
        }
      }
      return l ? (d(t, l), t.specification = o, p(t, a.technologyRow), await T(t), t.outboundUnitType === w.MEASURE.V ? t.number = t.quantity : t.number = t.quantity * t.theoryWeight, t) : (h.error({ message: `该科目下不存在规格为“${o}”的材料，请联系管理员/仓库人员添加`, duration: 5e3 }), false);
    }
    return false;
  }, T = async (e) => {
    if (i === s.STEEL_PLATE.V) {
      e.theoryWeight = await v({ classifyId: e.classifyId, name: e.classifyFullName, length: e.length, width: e.width, thickness: e.thickness });
      return;
    }
    if (i === s.SECTION_STEEL.V) {
      e.theoryWeight = await L({ length: e.length, unitWeight: e.unitWeight });
      return;
    }
  }, g = (e) => {
    switch (i) {
      case s.STEEL_PLATE.V:
        return e.material;
      case s.SECTION_STEEL.V:
        return `${e.specification} * ${e.material}`;
      default:
        return e.material;
    }
  }, p = (e, t) => {
    if (i === s.STEEL_PLATE.V) {
      e.thickness = t.specification;
      return;
    }
  };
  return { form: n, formRef: f, add: S, resetForm: () => {
    n.value = {};
  } };
}
export {
  P as u
};
